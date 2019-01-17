package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.impl

import de.uka.ipd.sdq.identifier.Identifier
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation
import edu.kit.ipd.sdq.dataflow.systemmodel.OperationCall
import java.util.ArrayList
import java.util.Map
import org.eclipse.emf.ecore.util.EcoreUtil
import org.jgrapht.Graph
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.DataEdge
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.PerformDataTransmissionOperation
import org.palladiosimulator.pcm.dataprocessing.profile.api.ProfileConstants
import org.palladiosimulator.pcm.system.System
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour
import org.palladiosimulator.pcm.usagemodel.Start

import static org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.EMFUtils.*

class UsageModelBehaviorTransformator extends BehaviorTransformator {
	
	new(TransformationFacilities transformationFacilities) {
		super(transformationFacilities)
	}
	
	override validateDataOpGraph(Graph<DataOperation, DataEdge> dataOpGraph) {
		if (dataOpGraph.outgoingEdgesOf(SEFF_DUMMY_OPERATION).size != 0) {
			throw new IllegalStateException("A usage model cannot provide any data.")
		}
	}
	
	override handleTransferOperation(PerformDataTransmissionOperation callerDataOperation, Operation caller, IdentifierInstance<DataOperation, AssemblyContext> callerInstance, Map<Data, LogicTerm> resultRefCache) {
		val actionCandidates = getStereotypedElements(ProfileConstants.STEREOTYPE_NAME_DATA_PROCESSING, callerDataOperation.container, Entity)
		val targetSEFF = determineCalledSEFF(actionCandidates, callerInstance)
		
		val targetDataOperation = targetSEFF.SEFFOperation
		val call = caller.getOperationCall(targetDataOperation)
		caller.calls += call

		for (inputMapping : callerDataOperation.inputMappings) {
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
		
		for (outputMapping : callerDataOperation.outputMappings) {
			val calledReturnVariable = outputMapping.from.getReturnVariable(targetSEFF)
	
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
	
	private def determineCalledSEFF(Iterable<Entity> callAction, IdentifierInstance<? extends Entity, AssemblyContext> callerInstance) {
		val elsc = callAction.filter(EntryLevelSystemCall).findFirst[true]
		val calledSignature = elsc.operationSignature__EntryLevelSystemCall
		
		val providedRole = elsc.providedRole_EntryLevelSystemCall
		val pcmSystem = EcoreUtil.getRootContainer(providedRole) as System
		val targetAssembly = pcmSystem.connectors__ComposedStructure.filter(ProvidedDelegationConnector).findFirst[outerProvidedRole_ProvidedDelegationConnector === providedRole].assemblyContext_ProvidedDelegationConnector
		val targetSEFFCandidates = targetAssembly.findAllSEFFs.filter[seff | seff.entity.describedService__SEFF === calledSignature]
		targetSEFFCandidates.findFirst[true]
	}
	
	override protected createReturnVariables(IdentifierInstance<? extends Identifier, AssemblyContext> behaviorIdentifier) {
		// Usage models cannot return data
		#[]
	}
	
	override protected createStateVariables(IdentifierInstance<? extends Identifier, AssemblyContext> behaviorIdentifier) {
		// Usage models cannot state data
		#[]
	}
	
	override protected createReturnValueAssignmentsForConsumerOperations(DataOperation consumerDataOp, AssemblyContext selfAssemblyContext, IdentifierInstance<? extends Identifier, AssemblyContext> selfInstance, OperationCall consumerOpCall) {
		// Usage models cannot return data
		#[]
	}
	
	override protected findAllDataOps(Identifier identifier) {
		var ops = new ArrayList<DataOperation>();
		for (var action = (identifier as ScenarioBehaviour).actions_ScenarioBehaviour.findFirst[a | a instanceof Start]; action !== null; action = action.successor) {
			ops += action.findAllDataOperationsOfStereotpyedEObject
		}
		ops
	}
	
	override protected getPropertySource(IdentifierInstance<? extends Identifier, AssemblyContext> instance) {
		// ScenarioBehavior itself
		instance.entity
	}
	
}