package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.impl

import de.uka.ipd.sdq.identifier.Identifier
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation
import edu.kit.ipd.sdq.dataflow.systemmodel.OperationCall
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment
import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.jgrapht.Graph
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.ComposedStructure
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.DataEdge
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.graph.DataOperationGraphFactory
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataProcessingContainer
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.PerformDataTransmissionOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ProcessingFactory
import org.palladiosimulator.pcm.dataprocessing.profile.api.ProfileConstants
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF
import org.palladiosimulator.pcm.seff.StartAction
import org.palladiosimulator.pcm.system.System

import static org.palladiosimulator.mdsdprofiles.api.StereotypeAPI.*

import static extension org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance.createInstance
import static extension org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance.createInstance

abstract class BehaviorTransformator {
	
	protected static val factory = SystemModelFactory.eINSTANCE
	protected static val DataOperation SEFF_DUMMY_OPERATION = ProcessingFactory.eINSTANCE.createStoreDataOperation
	
	protected extension val TransformationFacilities transformationFacilities
	
	new(TransformationFacilities transformationFacilities) {
		this.transformationFacilities = transformationFacilities
	}
	
	protected abstract def Iterable<DataOperation> findAllDataOps(Identifier identifier)
	
	protected def transformBehavior(Operation behaviorOperation, IdentifierInstance<? extends Identifier, AssemblyContext> selfInstance) {

		val selfAssemblyContext = selfInstance.identifier.orElse(null)
		val selfPropertySource = selfInstance.propertySource
		val dataOps = selfInstance.entity.findAllDataOps

		// create called operations
		val ops = dataOps.map[op | selfAssemblyContext.createInstance(op)].map[getOperation(selfPropertySource)]
		system.operations += ops
		
		val dataOpGraph = dataOps.createDataOpGraph
		validateDataOpGraph(dataOpGraph)
		
		// create return and state variables for behaviour operation
		behaviorOperation.returnValues += selfInstance.createReturnVariables
		behaviorOperation.stateVariables += selfInstance.createStateVariables
		
		
		/* transformation pattern for data operations
		 * 
		 * for every operation o1
		 *   - o1 calls o2 to receive required data d
		 *   - o1 does not transmit any data to o2 in the call
		 *   - o2 returns required data d to o1
		 *   - create return variable assignments of o1 based on available data
		 */ 
		
 		// for every required data, we create a value reference
 		for (dataOp : dataOps) {
			val resultRefCache = new HashMap<Data, LogicTerm>();
 			val callerInstance = selfAssemblyContext.createInstance(dataOp)
 			val caller = callerInstance.operation
 			val incomingEdges = dataOpGraph.incomingEdgesOf(dataOp).sortBy[data.id]
 			for (incomingEdge : incomingEdges) {
 				val incomingData = incomingEdge.data
 				val calledDataOperation = incomingEdge.findSource
				var LogicTerm dataRef;
				
 				if (calledDataOperation === SEFF_DUMMY_OPERATION) { 					
 					// no call required, data comes from the behaviour operation
 					val stateRef = factory.createStateRef
 					stateRef.stateVariable = incomingData.getStateVariable(selfInstance)
 					dataRef = stateRef
 					
 				} else {
 					// call required, data comes from another data operation
					val calleeInstance = selfAssemblyContext.createInstance(calledDataOperation)
					val callee = calleeInstance.operation
					val calleeVariable = incomingData.getReturnVariable(calleeInstance)
 					
					val call = caller.getOperationCall(callee)
					caller.calls += call
	
					val resultRef = factory.createReturnValueRef
					resultRef.call = call
					resultRef.returnValue = calleeVariable
					
					dataRef = resultRef
 				}
 				
				if (resultRefCache.put(incomingData, dataRef) !== null) {
					throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.")
				}
 				
 			}
 			
 			if (dataOp instanceof PerformDataTransmissionOperation) {
 				// handle data transmission specially because of decoupled data flows
 				dataOp.handleTransferOperation(caller, callerInstance, resultRefCache)
 			} else {
				// set return value assignments (actual data processing description)
	 			caller.returnValueAssignments += callerInstance.createReturnValueAssignments(resultRefCache) 				
 			}

 		}
 			
		// find consumer operations and call them
		val consumerOps = dataOpGraph.vertexSet.filter[dataOp | dataOp != SEFF_DUMMY_OPERATION].filter[v | dataOpGraph.outgoingEdgesOf(v).empty]
		for (consumerDataOp : consumerOps) {
			val consumerOp = selfAssemblyContext.createInstance(consumerDataOp).getOperation()
			val consumerOpCall = getOperationCall(behaviorOperation, consumerOp)
			behaviorOperation.calls += consumerOpCall
			behaviorOperation.returnValueAssignments += createReturnValueAssignmentsForConsumerOperations(consumerDataOp, selfAssemblyContext, selfInstance, consumerOpCall)
		}
	}
	
	protected abstract def EObject getPropertySource(IdentifierInstance<? extends Identifier, AssemblyContext> instance)
	
	protected abstract def Iterable<VariableAssignment> createReturnValueAssignmentsForConsumerOperations(DataOperation consumerDataOp, AssemblyContext selfAssemblyContext, IdentifierInstance<? extends Identifier, AssemblyContext> selfInstance, OperationCall consumerOpCall)
	
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
	protected abstract def void handleTransferOperation(PerformDataTransmissionOperation callerDataOperation, Operation caller, IdentifierInstance<DataOperation, AssemblyContext> callerInstance, Map<Data, LogicTerm> resultRefCache)
	
	protected def void validateDataOpGraph(Graph<DataOperation, DataEdge> dataOpGraph) {
		// intentionally left blank
	}
	
	protected abstract def Iterable<Variable> createReturnVariables(IdentifierInstance<? extends Identifier, AssemblyContext> behaviorIdentifier)
	protected abstract def Iterable<Variable> createStateVariables(IdentifierInstance<? extends Identifier, AssemblyContext> behaviorIdentifier)
	protected abstract def SEFFInstance determineCalledSEFF(Iterable<Entity> callAction, IdentifierInstance<? extends Entity, AssemblyContext> callerInstance)
	
	protected def createDataOpGraph(Iterable<DataOperation> dataOps) {
 		val factory = new DataOperationGraphFactory(SEFF_DUMMY_OPERATION)
 		return factory.createDataOpGraph(dataOps)
	}
	
	protected static def findAllSEFFs(System system) {
		system.assemblyContexts__ComposedStructure.map[findAllSEFFs].flatten
	}
	
	protected static def findAllSEFFs(AssemblyContext assembly) {
		val seffs = new LinkedHashSet<SEFFInstance>();
		val acQueue = new LinkedList<AssemblyContext>(#[assembly])
		while (!acQueue.isEmpty) {
			val ac = acQueue.pop
			val component = ac.encapsulatedComponent__AssemblyContext
			if (component instanceof ComposedStructure) {
				acQueue += component.assemblyContexts__ComposedStructure
			} else if (component instanceof BasicComponent) {
				seffs += component.serviceEffectSpecifications__BasicComponent.filter(ResourceDemandingSEFF).map [seff | ac.createInstance(seff)]
			}
		}
		seffs
	}
	
	protected def findAllDataOperations(ResourceDemandingSEFF seff) {
		//FIXME this does not consider nested actions
		var ops = new ArrayList<DataOperation>();
		for (var action = seff.steps_Behaviour.findFirst[a | a instanceof StartAction]; action !== null; action = action.successor_AbstractAction) {
			ops += action.findAllDataOperationsOfStereotpyedEObject
		}
		ops
	}
	
	protected def findAllDataOperationsOfStereotpyedEObject(EObject action) {
		if (!hasAppliedStereotype(#{action}, ProfileConstants.STEREOTYPE_NAME_DATA_PROCESSING)) {
			return #[]
		}
		val dataProcessingContainer = getTaggedValue(action, ProfileConstants.TAGGED_VALUE_NAME_DATA_PROCESSING_CONTAINER, ProfileConstants.STEREOTYPE_NAME_DATA_PROCESSING) as DataProcessingContainer
		dataProcessingContainer.operations
	}
	
}