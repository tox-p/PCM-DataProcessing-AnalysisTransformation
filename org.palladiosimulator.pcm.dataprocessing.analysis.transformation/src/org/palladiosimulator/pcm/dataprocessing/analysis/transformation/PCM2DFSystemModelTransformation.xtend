package org.palladiosimulator.pcm.dataprocessing.analysis.transformation

import edu.kit.ipd.sdq.dataflow.systemmodel.Caller
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation
import edu.kit.ipd.sdq.dataflow.systemmodel.ReturnValueRef
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Delegate
import org.palladiosimulator.pcm.allocation.Allocation
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.ComposedStructure
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.graph.DataOperationGraphFactory
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.Hash
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicType
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicLiteral
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicType
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.CreateDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataProcessingContainer
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.PerformDataTransmissionOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ProcessingFactory
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ReturnDataOperation
import org.palladiosimulator.pcm.dataprocessing.profile.api.ProfileConstants
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF
import org.palladiosimulator.pcm.system.System
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour
import org.palladiosimulator.pcm.usagemodel.UsageModel

import static org.palladiosimulator.mdsdprofiles.api.StereotypeAPI.*
import static org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.EMFUtils.*

import static extension org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance.createInstance
import static extension org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance.createInstance

class PCM2DFSystemModelTransformation implements PCM2IntermediateModelTransformator {
	
	static val DataOperation SEFF_DUMMY_OPERATION = ProcessingFactory.eINSTANCE.createStoreDataOperation
	static val factory = SystemModelFactory.eINSTANCE
	val extension UniqueNameProvider uniqueNameProvider = new CachedUniqueNameProvider()
	
	override transform(UsageModel pcmUsageModel, System pcmSystem, Allocation pcmAllocationModel, CharacteristicTypeContainer pcmCharacteristicTypeContainer) {
		system.name = pcmSystem.entityName
		system.types += pcmCharacteristicTypeContainer.characteristicTypes.map[valueType]
		system.operations += pcmSystem.findAllSEFFs.map[getSEFFOperation]
		system.systemusages += pcmUsageModel.usageScenario_UsageModel.map[scenarioBehaviour_UsageScenario].map[getSystemUsage]
		system
	}
	
	// TRANSFORMATION: n/a -> System
	
	protected def create sys: factory.createSystem getSystem() {
		
	}
	
	// TRANSFORMATION: CharacteristicType -> ValueType
	
	protected def create ct: characteristicType.transformCharacteristicType getValueType(CharacteristicType characteristicType) {
		// modification will be done by factory method 
	}

	protected def dispatch transformCharacteristicType(EnumCharacteristicType characteristic) {
		val valueSetType = factory.createValueSetType
		valueSetType.name = characteristic.uniqueName
		valueSetType.values += characteristic.enum.literals.map[getValue]
		valueSetType
	}
	
	protected def dispatch transformCharacteristicType(CharacteristicType characteristic) {
		throw new IllegalArgumentException("Unable to transform characteristic " + characteristic.class.name)
	}
	
	// TRANSFORMATION: Literal -> value
	
	protected def create value: factory.createValue getValue(EnumCharacteristicLiteral literal) {
		value.name = literal.uniqueName
	}
	
	// TRANSFORMATION: ScenarioBehaviour -> Operation
	
	protected def create sysUsageDataOp: factory.createOperation getSystemUsageDataOperation(ScenarioBehaviour scenarioBehavior) {
		sysUsageDataOp.name = scenarioBehavior.uniqueName + "_dataOp"
		
		val dataOps = scenarioBehavior.findAllDataOperations
		
		// create called operations
		val ops = dataOps.map[createInstance].map[getOperation]
		system.operations += ops
		
		val dataOpGraph = dataOps.createDataOpGraph
		if (dataOpGraph.outgoingEdgesOf(SEFF_DUMMY_OPERATION).size != 0) {
			throw new IllegalStateException("A usage model cannot provide any data.")
		}
		
		/* transformation pattern for data operations
		 * 
		 * for every operation o1
		 *   - o1 calls o2 to receive required data d
		 *   - o1 does not transmit any data to o2 in the call
		 *   - o2 returns required data d to o1
		 *   - create return variable assignments of o1 based on available data
		 */ 
		
 		// for every required data, we create a value reference
		val resultRefCache = new HashMap<Data, ReturnValueRef>();
 		for (dataOp : dataOps) {
 			val callerInstance = dataOp.createInstance
 			val caller = callerInstance.operation
 			val incomingEdges = dataOpGraph.incomingEdgesOf(dataOp)
 			for (incomingEdge : incomingEdges) {
 				val incomingData = incomingEdge.data
				val calleeInstance = incomingEdge.findSource.createInstance
				val callee = calleeInstance.operation
				val call = caller.getOperationCall(callee)
				caller.calls += call
				val calleeVariable = incomingData.getReturnVariable(calleeInstance)

				val resultRef = factory.createReturnValueRef
				resultRef.call = call
				resultRef.returnValue = calleeVariable
				if (resultRefCache.put(incomingData, resultRef) !== null) {
					throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
				}
 				
 			}
 			
 			// handle calls
 			if (dataOp instanceof PerformDataTransmissionOperation) {
 				
 				/*
 				 * Data transmissions have to be treated special because they decouple data
 				 * operations by indirect data flows:
 				 * - data transmissions map input data and output data
 				 * - input data from:  data contained in the current SEFF/UsageModel
 				 * - input data to:    data defined in the operation signature refinement
 				 * - output data from: data defined in the operation signature refinement
 				 * - output data to:   data contained in the data transmission operation
 				 * 
 				 * Data operations in the current SEFF/UsageModel always only refer to data
 				 * defined/contained in the current SEFF/UsageModel. This case is already
 				 * handled by the general code above.
 				 * 
 				 * The special handling is about copying the characteristics between the
 				 * called SEFF and the calling SEFF/UsageModel. We have to
 				 * - create state variables for "input.to" in target SEFF operation
 				 * - copy characteristics from "input.from" to "input.to" in the call
 				 * - create return variables for "output.from" in target SEFF operation
 				 * - copy characteristics from "output.from" to "output.to" in the return value assignments
 				 */
 				
 				val actionCandidates = getStereotypedElements(ProfileConstants.STEREOTYPE_NAME_DATA_PROCESSING, dataOp.container, EntryLevelSystemCall)
				if (actionCandidates.size != 1) {
					throw new IllegalStateException("A data transmission operation in a usage model must be attached to exactly one entry level system call.")
				}
				val elsc = actionCandidates.findFirst[true]

				val calledSignature = elsc.operationSignature__EntryLevelSystemCall
				
				val providedRole = elsc.providedRole_EntryLevelSystemCall
				val pcmSystem = EcoreUtil.getRootContainer(providedRole) as System
				val targetAssembly = pcmSystem.connectors__ComposedStructure.filter(ProvidedDelegationConnector).findFirst[outerProvidedRole_ProvidedDelegationConnector === providedRole].assemblyContext_ProvidedDelegationConnector
				val targetSEFFCandidates = targetAssembly.findAllSEFFs.filter[seff | seff.entity.describedService__SEFF === calledSignature]
				val targetSEFF = targetSEFFCandidates.findFirst[true]
				
				val targetDataOperation = targetSEFF.SEFFOperation
				val call = caller.getOperationCall(targetDataOperation)
				caller.calls += call
				
 				val transmissionOp = dataOp as PerformDataTransmissionOperation
 				
				for (inputMapping : transmissionOp.inputMappings) {
					val targetParameterData = inputMapping.to
					val targetStateVariable = targetParameterData.getStateVariable(targetSEFF)
					targetDataOperation.stateVariables += targetStateVariable //TODO put in SEFF construction
					val sourceData = inputMapping.from
					
					// copy assignments from sourceReturnVariable to targetStateVariable
					val assignment = factory.createVariableAssignment
					assignment.term = resultRefCache.get(sourceData)
					assignment.variable = targetStateVariable
					call.preCallStateDefinitions += assignment					
				}
				
				val targetReturnOperations = newImmutableMap(targetSEFF.entity.findAllDataOperations.filter(ReturnDataOperation).map[o | o.returnDestination -> o])
				
				for (outputMapping : transmissionOp.outputMappings) {
					val calledDataOp = targetReturnOperations.get(outputMapping.from)
					val calledDataOpInstance = targetSEFF.ac.createInstance(calledDataOp as DataOperation)
					val calledReturnVariable = outputMapping.from.getReturnVariable(calledDataOpInstance)

					val selfReturnVariable = outputMapping.to.getReturnVariable(callerInstance)
					caller.returnValues += selfReturnVariable

					val resultRef = factory.createReturnValueRef
					resultRef.call = call
					resultRef.returnValue = calledReturnVariable

					val assignment = factory.createVariableAssignment
					assignment.term = resultRef
					assignment.variable = selfReturnVariable

					callerInstance.operation.returnValueAssignments += assignment
				}


 				
 			}

 			caller.returnValueAssignments += callerInstance.createReturnValueAssignments(resultRefCache)

 		}
		
		// find consumer operations and call them
		val consumerOps = dataOpGraph.vertexSet.filter[dataOp | dataOp != SEFF_DUMMY_OPERATION].filter[v | dataOpGraph.outgoingEdgesOf(v).empty]
		sysUsageDataOp.calls += consumerOps.map[consumerOp | consumerOp.createInstance.getOperation()].map[consumerOp | getOperationCall(sysUsageDataOp, consumerOp)]
	}
	
	
	
	
	
	
	
	
	protected def transformBehavior() {
		val dataOps = scenarioBehavior.findAllDataOperations
		
		// create called operations
		val ops = dataOps.map[createInstance].map[getOperation]
		system.operations += ops
		
		val dataOpGraph = dataOps.createDataOpGraph
		if (dataOpGraph.outgoingEdgesOf(SEFF_DUMMY_OPERATION).size != 0) {
			throw new IllegalStateException("A usage model cannot provide any data.")
		}
		
		/* transformation pattern for data operations
		 * 
		 * for every operation o1
		 *   - o1 calls o2 to receive required data d
		 *   - o1 does not transmit any data to o2 in the call
		 *   - o2 returns required data d to o1
		 *   - create return variable assignments of o1 based on available data
		 */ 
		
 		// for every required data, we create a value reference
		val resultRefCache = new HashMap<Data, ReturnValueRef>();
 		for (dataOp : dataOps) {
 			val callerInstance = dataOp.createInstance
 			val caller = callerInstance.operation
 			val incomingEdges = dataOpGraph.incomingEdgesOf(dataOp)
 			for (incomingEdge : incomingEdges) {
 				val incomingData = incomingEdge.data
				val calleeInstance = incomingEdge.findSource.createInstance
				val callee = calleeInstance.operation
				val call = caller.getOperationCall(callee)
				caller.calls += call
				val calleeVariable = incomingData.getReturnVariable(calleeInstance)

				val resultRef = factory.createReturnValueRef
				resultRef.call = call
				resultRef.returnValue = calleeVariable
				if (resultRefCache.put(incomingData, resultRef) !== null) {
					throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
				}
 				
 			}
 			
 			// handle calls
 			if (dataOp instanceof PerformDataTransmissionOperation) {
 				
 				/*
 				 * Data transmissions have to be treated special because they decouple data
 				 * operations by indirect data flows:
 				 * - data transmissions map input data and output data
 				 * - input data from:  data contained in the current SEFF/UsageModel
 				 * - input data to:    data defined in the operation signature refinement
 				 * - output data from: data defined in the operation signature refinement
 				 * - output data to:   data contained in the data transmission operation
 				 * 
 				 * Data operations in the current SEFF/UsageModel always only refer to data
 				 * defined/contained in the current SEFF/UsageModel. This case is already
 				 * handled by the general code above.
 				 * 
 				 * The special handling is about copying the characteristics between the
 				 * called SEFF and the calling SEFF/UsageModel. We have to
 				 * - create state variables for "input.to" in target SEFF operation
 				 * - copy characteristics from "input.from" to "input.to" in the call
 				 * - create return variables for "output.from" in target SEFF operation
 				 * - copy characteristics from "output.from" to "output.to" in the return value assignments
 				 */
 				
 				val actionCandidates = getStereotypedElements(ProfileConstants.STEREOTYPE_NAME_DATA_PROCESSING, dataOp.container, EntryLevelSystemCall)
				if (actionCandidates.size != 1) {
					throw new IllegalStateException("A data transmission operation in a usage model must be attached to exactly one entry level system call.")
				}
				val elsc = actionCandidates.findFirst[true]

				val calledSignature = elsc.operationSignature__EntryLevelSystemCall
				
				val providedRole = elsc.providedRole_EntryLevelSystemCall
				val pcmSystem = EcoreUtil.getRootContainer(providedRole) as System
				val targetAssembly = pcmSystem.connectors__ComposedStructure.filter(ProvidedDelegationConnector).findFirst[outerProvidedRole_ProvidedDelegationConnector === providedRole].assemblyContext_ProvidedDelegationConnector
				val targetSEFFCandidates = targetAssembly.findAllSEFFs.filter[seff | seff.entity.describedService__SEFF === calledSignature]
				val targetSEFF = targetSEFFCandidates.findFirst[true]
				
				val targetDataOperation = targetSEFF.SEFFOperation
				val call = caller.getOperationCall(targetDataOperation)
				caller.calls += call
				
 				val transmissionOp = dataOp as PerformDataTransmissionOperation
 				
				for (inputMapping : transmissionOp.inputMappings) {
					val targetParameterData = inputMapping.to
					val targetStateVariable = targetParameterData.getStateVariable(targetSEFF)
					targetDataOperation.stateVariables += targetStateVariable //TODO put in SEFF construction
					val sourceData = inputMapping.from
					
					// copy assignments from sourceReturnVariable to targetStateVariable
					val assignment = factory.createVariableAssignment
					assignment.term = resultRefCache.get(sourceData)
					assignment.variable = targetStateVariable
					call.preCallStateDefinitions += assignment					
				}
				
				val targetReturnOperations = newImmutableMap(targetSEFF.entity.findAllDataOperations.filter(ReturnDataOperation).map[o | o.returnDestination -> o])
				
				for (outputMapping : transmissionOp.outputMappings) {
					val calledDataOp = targetReturnOperations.get(outputMapping.from)
					val calledDataOpInstance = targetSEFF.ac.createInstance(calledDataOp as DataOperation)
					val calledReturnVariable = outputMapping.from.getReturnVariable(calledDataOpInstance)

					val selfReturnVariable = outputMapping.to.getReturnVariable(callerInstance)
					caller.returnValues += selfReturnVariable

					val resultRef = factory.createReturnValueRef
					resultRef.call = call
					resultRef.returnValue = calledReturnVariable

					val assignment = factory.createVariableAssignment
					assignment.term = resultRef
					assignment.variable = selfReturnVariable

					callerInstance.operation.returnValueAssignments += assignment
				}


 				
 			}

 			caller.returnValueAssignments += callerInstance.createReturnValueAssignments(resultRefCache)

 		}
		
		// find consumer operations and call them
		val consumerOps = dataOpGraph.vertexSet.filter[dataOp | dataOp != SEFF_DUMMY_OPERATION].filter[v | dataOpGraph.outgoingEdgesOf(v).empty]
		sysUsageDataOp.calls += consumerOps.map[consumerOp | consumerOp.createInstance.getOperation()].map[consumerOp | getOperationCall(sysUsageDataOp, consumerOp)]
	}
	
	
	
	
	
	
	
	
	// TRANSFORMATION: ScenarioBehavior -> SystemUsage
	
	protected def create sysUsage: factory.createSystemUsage getSystemUsage(ScenarioBehaviour scenarioBehavior) {
		sysUsage.name = scenarioBehavior.uniqueName
		
		val delegateOperation = scenarioBehavior.systemUsageDataOperation
		system.operations += delegateOperation
		sysUsage.calls += sysUsage.getOperationCall(delegateOperation)
		
		// we just do one call to the operation and do not pass any information
	}
	
	protected def createInstance(DataOperation dataOp) {
		// ensure that this is only called from usage model classes
		new IdentifierInstance(dataOp, null)
	}
	
	// TRANSFORMATION: SEFFInstance -> Operation
	protected def create op: factory.createOperation getSEFFOperation(SEFFInstance seffInstance) {
		op.name = seffInstance.uniqueName
		
//		val dataOps = seffInstance.entity.findAllDataOperations
//
//		// parameters
//		val inputParameters = seffInstance.entity.parameterBasedData
//		op.stateVariables += inputParameters.map[getStateVariable(seffInstance)]
//		// state variables have to be initialized in the operation call to this SEFF
// 		
// 		// create all dependent operations
// 		val dataOpGraph = dataOps.createDataOpGraph
// 		val ops = dataOps.map[dataOp | seffInstance.ac.createInstance(dataOp)].map[getOperation]
// 		system.operations += ops
// 		
// 		
// 		
// 		// create references for required data
// 		val stateRefCache = new HashMap<Data, StateRef>();
//		val resultRefCache = new HashMap<Data, ReturnValueRef>();
// 		for (dataOp : dataOps) {
// 			val callerInstance = seffInstance.ac.createInstance(dataOp)
// 			val caller = callerInstance.operation
// 			val incomingEdges = dataOpGraph.incomingEdgesOf(dataOp)
// 			for (incomingEdge : incomingEdges) {
// 				val incomingData = incomingEdge.data
// 				var LogicTerm incomingDataRef;
// 				if (incomingEdge.findSource == SEFF_DUMMY_OPERATION) {
//					val seffVariable = incomingData.getStateVariable(seffInstance)
//
//					val stateRef = factory.createStateRef
//					stateRef.stateVariable = seffVariable
//					incomingDataRef = stateRef
//					if (stateRefCache.put(incomingData, stateRef) !== null) {
//						throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
//					}
// 				} else {
// 					val calleeInstance = seffInstance.ac.createInstance(incomingEdge.findSource)
// 					val callee = calleeInstance.operation
// 					val call = caller.getOperationCall(callee)
//					val calleeVariable = incomingData.getReturnVariable(calleeInstance)
//					
//					val resultRef = factory.createReturnValueRef
//					resultRef.call = call
//					resultRef.returnValue = calleeVariable
//					incomingDataRef = resultRef
//					if (resultRefCache.put(incomingData, resultRef) !== null) {
//						throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
//					}
// 				}
// 			}
// 			caller.returnValueAssignments += callerInstance.createReturnValueAssignments(resultRefCache)
// 		}
// 		
//		// return values
//		for (returnOperation : dataOps.filter(ReturnDataOperation)) {
//			val calledOperation = seffInstance.ac.createInstance(returnOperation as DataOperation).getOperation()
//			val resultData = returnOperation.consumedData
//			val returnValue = resultData.getReturnVariable(seffInstance)
//			val returnAssignment = factory.createVariableAssignment
//			returnAssignment.variable = returnValue
//
//			val returnValueRef = factory.createReturnValueRef
//			returnAssignment.term = returnValueRef
//			returnValueRef.call = getOperationCall(op, calledOperation)
//			val calledOperationReturnValue = resultData.getReturnVariable(seffInstance.ac.createInstance(returnOperation))
//			calledOperation.returnValues += calledOperationReturnValue
//			returnValueRef.returnValue =  calledOperationReturnValue
//			
//			op.returnValues += returnValue
//			op.returnValueAssignments += returnAssignment
//		}
//
//		// find consumer operations and call them
//		val consumerOps = dataOpGraph.vertexSet.filter[dataOp | dataOp != SEFF_DUMMY_OPERATION].filter[v | dataOpGraph.outgoingEdgesOf(v).empty]
//		op.calls += consumerOps.map[consumerOp | seffInstance.ac.createInstance(consumerOp).getOperation()].map[consumerOp | getOperationCall(op, consumerOp)]
	}
	
	def List<VariableAssignment> createReturnValueAssignments(IdentifierInstance<DataOperation, ?> opInstance, Map<Data, ReturnValueRef> availableData) {
		//TODO implement me using createReturnValueAssignments
		val result = new ArrayList<VariableAssignment>();
		for (availableDataEntry : availableData.entrySet) {
			result += opInstance.createReturnValueAssignments(availableDataEntry.key, availableDataEntry.value)
		}
		return result
	}
	
	def List<VariableAssignment> createReturnValueAssignments(IdentifierInstance<DataOperation, ?> opInstance, Data data, LogicTerm term) {
		// this method should be replaced by an extension mechanism
		opInstance.entity.createReturnValueAssignments2(opInstance, data, term)
	}



	def dispatch List<VariableAssignment> createReturnValueAssignments2(DataOperation op, IdentifierInstance<DataOperation, ?> opInstance, Data data, LogicTerm term) {
		#[]
	}
	
	def dispatch List<VariableAssignment> createReturnValueAssignments2(ReturnDataOperation op, IdentifierInstance<DataOperation, ?> opInstance, Data data, LogicTerm term) {
		val assignment = factory.createVariableAssignment
		assignment.term = term
		assignment.variable = data.getReturnVariable(opInstance)
		#[assignment]
	}
	
	def dispatch List<VariableAssignment> createReturnValueAssignments2(CreateDataOperation op, IdentifierInstance<DataOperation, ?> opInstance, Data data, LogicTerm term) {
		/*
		 * There are two options to handle create:
		 * - do nothing as other operations have to perform adjustments
		 * - lookup default assignments and apply them
		 */
		#[]
	}
	
	def dispatch List<VariableAssignment> createReturnValueAssignments2(PerformDataTransmissionOperation op, IdentifierInstance<DataOperation, ?> opInstance, Data data, LogicTerm term) { 
//		val assignments = new ArrayList()
//		
//		val actionCandidates = getStereotypedElements("DataProcessingSpecification", op.container)
//		val elsc = actionCandidates.filter(EntryLevelSystemCall).findFirst[true]
//		if (elsc !== null) {
//			val calledSignature = elsc.operationSignature__EntryLevelSystemCall
//			
//			val providedRole = elsc.providedRole_EntryLevelSystemCall
//			val pcmSystem = EcoreUtil.getRootContainer(providedRole) as System
//			val targetAssembly = pcmSystem.connectors__ComposedStructure.filter(ProvidedDelegationConnector).findFirst[outerProvidedRole_ProvidedDelegationConnector === providedRole].assemblyContext_ProvidedDelegationConnector
//			
//			// this is a shortcut which might lead to wrong results, we would have to go through the roles...
//			val targetSEFFCandidates = targetAssembly.findAllSEFFs.filter[seff | seff.entity.describedService__SEFF === calledSignature]
//			val targetSEFF = targetSEFFCandidates.findFirst[true]
//			
//			val inputParameters = targetSEFF.entity.parameterBasedData
//			val stateVariables = inputParameters.map[getStateVariable(targetSEFF)]
//			
////			for (stateVariable : stateVariables) {
////				val assignment = factory.createVariableAssignment
////				assignment.term = term
////				assignment.variable = data.getReturnVariable(opInstance)
////				assignments += assignment
////			}
//		}
//		
//		val eca = actionCandidates.filter(ExternalCallAction).findFirst[true]
//		if (eca !== null) {
//			
//		}
		
		
		#[]
	}

	
	

	
	
	
	
	// TRANSFORMATION: SEFFInstance, DataOperation -> Operation
	protected def create op: factory.createOperation getOperation(IdentifierInstance<DataOperation, ?> dataOpInstance) {
		op.name = dataOpInstance.uniqueName
		
		// we never have input parameters
		// we might use state variables but we have to handle this later
		
		var outgoingData = dataOpInstance.entity.outgoingData + #[dataOpInstance.entity].filter(ReturnDataOperation).map[returnDestination]
		op.returnValues += outgoingData.map[getReturnVariable(dataOpInstance)]
		
		// we have to determine calls later
	}

	// TRANSFORMATION: SEFFInstance, Operation/Operation -> OperationCall
	protected def create opCall: factory.createOperationCall getOperationCall(Caller from, Operation to) {
		opCall.caller = from
		opCall.callee = to
		opCall.name = 'opCall_' + Hash.init(from.name).add(to.name).hash
	}

	protected def createDataOpGraph(Iterable<DataOperation> dataOps) {
 		val factory = new DataOperationGraphFactory(SEFF_DUMMY_OPERATION)
 		return factory.createDataOpGraph(dataOps)
	}
	
	// TRANSFORMATION: Data -> Variable
	protected def getStateVariable(Data data, IdentifierInstance<?, ?> instance) {
		data.getVariable(VariablePurpose.STATE, instance)
	}
	
	protected def getParameterVariable(Data data, IdentifierInstance<?, ?> instance) {
		data.getVariable(VariablePurpose.PARAMETER, instance)
	}
	
	protected def getReturnVariable(Data data, IdentifierInstance<?, ?> instance) {
		data.getVariable(VariablePurpose.RETURN, instance)
	}
	
	protected def create variable: factory.createVariable getVariable(Data data, VariablePurpose purpose, IdentifierInstance<?, ?> entityInstance) {
		variable.name = '''«data.entityName»_«purpose»_«Hash.init(entityInstance.uniqueName).add(data.uniqueName).hash»'''
		variable.datatype = data.type.dataType
	}
	
	
	private enum VariablePurpose {
		PARAMETER,
		STATE,
		RETURN
	}
	
	
	
	// TRANSFORMATION: DataType -> DataType
	protected def getDataType(DataType dataType) {
		getDataTypeInternal(new DataTypeWrapper(dataType, uniqueNameProvider))
	}
	
	@org.eclipse.xtend.lib.annotations.Data
	protected static class DataTypeWrapper implements DataType {
		
		@Delegate val DataType delegate
		val UniqueNameProvider nameProvider
	
		new(DataType type, UniqueNameProvider nameProvider) {
			delegate = type
			this.nameProvider = nameProvider
		}
	
		override hashCode() {
			nameProvider.uniqueName(delegate).hashCode
		}
		
		override equals(Object o) {
			o instanceof DataType && o.hashCode === hashCode
		}
	}
	
	protected def create dt: factory.createDataType getDataTypeInternal(DataType dataType) {
		dt.name = dataType.uniqueName
		system.datatypes += dt
	}

	
	// UTILITIES: lookup methods


	protected def findAllSEFFs(System system) {
		system.assemblyContexts__ComposedStructure.map[findAllSEFFs].flatten
	}
	
	protected def findAllSEFFs(AssemblyContext assembly) {
		val seffs = new HashSet<SEFFInstance>();
		val acQueue = new LinkedList<AssemblyContext>(#[assembly])
		while (!acQueue.isEmpty) {
			val ac = acQueue.pop
			val component = ac.encapsulatedComponent__AssemblyContext
			if (component instanceof ComposedStructure) {
				acQueue += component.assemblyContexts__ComposedStructure
			} else if (component instanceof BasicComponent) {
				seffs += component.serviceEffectSpecifications__BasicComponent.filter(ResourceDemandingSEFF).map [seff |
					ac.createInstance(seff)
				]
			}
		}
		seffs
	}
	
	protected def findAllDataOperations(ScenarioBehaviour sb) {
		sb.actions_ScenarioBehaviour.map[findAllDataOperationsOfStereotpyedEObject].flatten
	}
	
	protected def findAllDataOperations(ResourceDemandingSEFF seff) {
		seff.steps_Behaviour.map[findAllDataOperationsOfStereotpyedEObject].flatten
	}
	
	protected def findAllDataOperationsOfStereotpyedEObject(EObject action) {
		if (!hasAppliedStereotype(#{action}, "DataProcessingSpecification")) {
			return #[]
		}
		val dataProcessingContainer = getTaggedValue(action, "dataProcessingContainer", "DataProcessingSpecification") as DataProcessingContainer
		dataProcessingContainer.operations
	}
	
}