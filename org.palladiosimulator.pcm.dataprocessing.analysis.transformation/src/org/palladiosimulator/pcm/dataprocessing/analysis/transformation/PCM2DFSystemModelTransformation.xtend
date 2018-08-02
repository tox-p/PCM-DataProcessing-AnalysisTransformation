package org.palladiosimulator.pcm.dataprocessing.analysis.transformation

import de.uka.ipd.sdq.identifier.Identifier
import edu.kit.ipd.sdq.dataflow.systemmodel.Caller
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation
import edu.kit.ipd.sdq.dataflow.systemmodel.ReturnValueRef
import edu.kit.ipd.sdq.dataflow.systemmodel.StateRef
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Delegate
import org.palladiosimulator.pcm.allocation.Allocation
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.ComposedStructure
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.graph.DataOperationGraphFactory
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.Hash
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicType
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicLiteral
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicType
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataProcessingContainer
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ProcessingFactory
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ReturnDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.seff.DataSEFFSpecification
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification
import org.palladiosimulator.pcm.system.System
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour
import org.palladiosimulator.pcm.usagemodel.UsageModel

import static org.palladiosimulator.mdsdprofiles.api.StereotypeAPI.*

import static extension org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance.createInstance
import static extension org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance.createInstance
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.PerformDataTransmissionOperation
import static org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.EMFUtils.*
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall
import org.palladiosimulator.pcm.seff.ExternalCallAction
import org.eclipse.emf.ecore.util.EcoreUtil
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector

class PCM2DFSystemModelTransformation implements PCM2IntermediateModelTransformator {
	
	static val DataOperation SEFF_DUMMY_OPERATION = ProcessingFactory.eINSTANCE.createStoreDataOperation
	static val factory = SystemModelFactory.eINSTANCE
	
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
	
	
	// TRANSFORMATION: ScenarioBehavior -> SystemUsage
	protected def create sysUsage: factory.createSystemUsage getSystemUsage(ScenarioBehaviour scenarioBehavior) {
		sysUsage.name = scenarioBehavior.uniqueName
		
		val dataOps = scenarioBehavior.findAllDataOperations
		
		// create called operations
		val ops = dataOps.map[createInstance].map[getOperation]
		system.operations += ops
		
		val dataOpGraph = dataOps.createDataOpGraph
		if (dataOpGraph.outgoingEdgesOf(SEFF_DUMMY_OPERATION).size != 0) {
			throw new IllegalStateException("A usage model cannot provide any data.")
		}
		
 		// create references for required data
		val resultRefCache = new HashMap<Data, ReturnValueRef>();  
 		for (dataOp : dataOps) {
 			val callerInstance = createInstance(dataOp)
 			val caller = callerInstance.operation
 			val incomingEdges = dataOpGraph.incomingEdgesOf(dataOp)
 			for (incomingEdge : incomingEdges) {
 				val incomingData = incomingEdge.data
 				var LogicTerm incomingDataRef;

				val calleeInstance = createInstance(incomingEdge.findSource)
				val callee = calleeInstance.operation
				val call = caller.getOperationCall(callee)
				val calleeVariable = incomingData.getReturnVariable(calleeInstance)

				val resultRef = factory.createReturnValueRef
				resultRef.call = call
				resultRef.returnValue = calleeVariable
				incomingDataRef = resultRef
				if (resultRefCache.put(incomingData, resultRef) !== null) {
					throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
				}
 				
 				caller.returnValueAssignments += callerInstance.createReturnValueAssignments(incomingData, incomingDataRef)
 			}
 		}
		
		// find consumer operations and call them
		val consumerOps = dataOpGraph.vertexSet.filter[dataOp | dataOp != SEFF_DUMMY_OPERATION].filter[v | dataOpGraph.outgoingEdgesOf(v).empty]
		sysUsage.calls += consumerOps.map[consumerOp | consumerOp.createInstance.getOperation()].map[consumerOp | getOperationCall(sysUsage, consumerOp)]
	}
	
	protected def createInstance(DataOperation dataOp) {
		// ensure that this is only called from usage model classes
		new IdentifierInstance(dataOp, null)
	}
	
	// TRANSFORMATION: SEFFInstance -> Operation
	protected def create op: factory.createOperation getSEFFOperation(SEFFInstance seffInstance) {
		op.name = seffInstance.uniqueName
		
		val dataOps = seffInstance.entity.findAllDataOperations

		// parameters
		val inputParameters = seffInstance.entity.parameterBasedData
		op.stateVariables += inputParameters.map[getStateVariable(seffInstance)]
		// state variables have to be initialized in the operation call to this SEFF
 		
 		// create all dependent operations
 		val dataOpGraph = dataOps.createDataOpGraph
 		val ops = dataOps.map[dataOp | seffInstance.ac.createInstance(dataOp)].map[getOperation]
 		system.operations += ops
 		
 		
 		
 		// create references for required data
 		val stateRefCache = new HashMap<Data, StateRef>();
		val resultRefCache = new HashMap<Data, ReturnValueRef>();
 		for (dataOp : dataOps) {
 			val callerInstance = seffInstance.ac.createInstance(dataOp)
 			val caller = callerInstance.operation
 			val incomingEdges = dataOpGraph.incomingEdgesOf(dataOp)
 			for (incomingEdge : incomingEdges) {
 				val incomingData = incomingEdge.data
 				var LogicTerm incomingDataRef;
 				if (incomingEdge.findSource == SEFF_DUMMY_OPERATION) {
					val seffVariable = incomingData.getStateVariable(seffInstance)

					val stateRef = factory.createStateRef
					stateRef.stateVariable = seffVariable
					incomingDataRef = stateRef
					if (stateRefCache.put(incomingData, stateRef) !== null) {
						throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
					}
 				} else {
 					val calleeInstance = seffInstance.ac.createInstance(incomingEdge.findSource)
 					val callee = calleeInstance.operation
 					val call = caller.getOperationCall(callee)
					val calleeVariable = incomingData.getReturnVariable(calleeInstance)

					val resultRef = factory.createReturnValueRef
					resultRef.call = call
					resultRef.returnValue = calleeVariable
					incomingDataRef = resultRef
					if (resultRefCache.put(incomingData, resultRef) !== null) {
						throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
					}
 				}
 				caller.returnValueAssignments += callerInstance.createReturnValueAssignments(incomingData, incomingDataRef)
 			}
 		}
 		
		// return values
		for (returnOperation : dataOps.filter(ReturnDataOperation)) {
			val calledOperation = seffInstance.ac.createInstance(returnOperation as DataOperation).getOperation()
			val resultData = returnOperation.consumedData
			val returnValue = resultData.getReturnVariable(seffInstance)
			val returnAssignment = factory.createVariableAssignment
			returnAssignment.variable = returnValue

			val returnValueRef = factory.createReturnValueRef
			returnAssignment.term = returnValueRef
			returnValueRef.call = getOperationCall(op, calledOperation)
			val calledOperationReturnValue = resultData.getReturnVariable(seffInstance.ac.createInstance(returnOperation))
			calledOperation.returnValues += calledOperationReturnValue
			returnValueRef.returnValue =  calledOperationReturnValue
			
			op.returnValues += returnValue
			op.returnValueAssignments += returnAssignment
		}

		// find consumer operations and call them
		val consumerOps = dataOpGraph.vertexSet.filter[dataOp | dataOp != SEFF_DUMMY_OPERATION].filter[v | dataOpGraph.outgoingEdgesOf(v).empty]
		op.calls += consumerOps.map[consumerOp | seffInstance.ac.createInstance(consumerOp).getOperation()].map[consumerOp | getOperationCall(op, consumerOp)]
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
	
	def dispatch List<VariableAssignment> createReturnValueAssignments2(PerformDataTransmissionOperation op, IdentifierInstance<DataOperation, ?> opInstance, Data data, LogicTerm term) { 
		val actionCandidates = getStereotypedElements("DataProcessingSpecification", op.container)
		val elsc = actionCandidates.filter(EntryLevelSystemCall).findFirst[true]
		if (elsc !== null) {
			val calledSignature = elsc.operationSignature__EntryLevelSystemCall
			
			val providedRole = elsc.providedRole_EntryLevelSystemCall
			val pcmSystem = EcoreUtil.getRootContainer(providedRole) as System
			val targetAssembly = pcmSystem.connectors__ComposedStructure.filter(ProvidedDelegationConnector).findFirst[outerProvidedRole_ProvidedDelegationConnector === providedRole].assemblyContext_ProvidedDelegationConnector
			
			// this is a shortcut which might lead to wrong results, we would have to go through the roles...
			val targetSEFFCandidates = targetAssembly.findAllSEFFs.filter[seff | seff.entity.describedService__SEFF === calledSignature]
			val targetSEFF = targetSEFFCandidates.findFirst[true]
			
			val inputParameters = targetSEFF.entity.parameterBasedData
			val stateVariables = inputParameters.map[getStateVariable(targetSEFF)]
			
		}
		
		val eca = actionCandidates.filter(ExternalCallAction).findFirst[true]
		if (eca !== null) {
			
		}
		
		
		#[]
	}

	
	

	
	
	
	
	// TRANSFORMATION: SEFFInstance, DataOperation -> Operation
	protected def create op: factory.createOperation getOperation(IdentifierInstance<DataOperation, ?> dataOpInstance) {
		op.name = dataOpInstance.uniqueName
		
		// we never have input parameters
		// we might use state variables but we have to handle this later
		
		var outgoingData = dataOpInstance.entity.outgoingData + (if (dataOpInstance.entity instanceof ReturnDataOperation) dataOpInstance.entity.incomingData else #[])
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
		variable.datatype = data.type.dataType
		variable.name = '''«data.uniqueName»_«purpose»_«entityInstance.uniqueName»'''
		//variable.name = data.uniqueName + purpose.toString + entityInstance.uniqueName
	}
	
	
	private enum VariablePurpose {
		PARAMETER,
		STATE,
		RETURN
	}
	
	
	
	// TRANSFORMATION: DataType -> DataType
	protected def getDataType(DataType dataType) {
		getDataTypeInternal(new DataTypeWrapper(dataType))
	}
	
	@org.eclipse.xtend.lib.annotations.Data
	protected static class DataTypeWrapper implements DataType {
		
		@Delegate val DataType delegate
	
		new(DataType type) {
			delegate = type
		}
	
		override hashCode() {
			delegate.uniqueName.hashCode
		}
		
		override equals(Object o) {
			o instanceof DataType && o.hashCode === hashCode
		}
	}
	
	protected def create dt: factory.createDataType getDataTypeInternal(DataType dataType) {
		dt.name = dataType.uniqueName
		system.datatypes += dt
	}

	
	// UTILITIES: Unique name calculations
	
	protected static def String uniqueName(Entity entity)
	'''«entity.entityName»_(«entity.id»)'''
	
	protected static def String uniqueName(Identifier entity)
	'''«entity.class.name»_«entity.id»'''
	
	protected static def String uniqueName(DataType dataType) {
		dataType.uniqueNameDataType
	}
	
	protected static def dispatch String uniqueNameDataType(PrimitiveDataType dataType)
	'''primitiveDataType_«dataType.type.getName»'''
	
	protected static def dispatch String uniqueNameDataType(Entity dataType) {
		dataType.uniqueName
	}
	
	protected static def dispatch String uniqueNameDataType(DataTypeWrapper dataType) {
		dataType.delegate.uniqueNameDataType
	}
	


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
		sb.actions_ScenarioBehaviour.map[findAllDataOperations].flatten
	}
	
	protected def findAllDataOperations(ResourceDemandingSEFF seff) {
		seff.steps_Behaviour.map[findAllDataOperations].flatten
	}
	
	protected def findAllDataOperations(EObject action) {
		if (!hasAppliedStereotype(#{action}, "DataProcessingSpecification")) {
			return #[]
		}
		val dataProcessingContainer = getTaggedValue(action, "dataProcessingContainer", "DataProcessingSpecification") as DataProcessingContainer
		dataProcessingContainer.operations
	}
	
	protected static def getParameterBasedData(ServiceEffectSpecification seff) {
		if (isStereotypeApplied(seff, "DataSeffSpecification")) {
			var dataParameters = getTaggedValue(seff, "dataSeffSpecification", "DataSeffSpecification") as DataSEFFSpecification
			return dataParameters.inputData
		}
		return #[]
	}
	
}