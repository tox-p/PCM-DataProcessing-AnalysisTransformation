package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.impl

import de.uka.ipd.sdq.identifier.Identifier
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation
import edu.kit.ipd.sdq.dataflow.systemmodel.OperationCall
import java.util.Map
import org.palladiosimulator.pcm.core.composition.AssemblyConnector
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.PerformDataTransmissionOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ReturnDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.repository.OperationSignatureDataRefinement
import org.palladiosimulator.pcm.dataprocessing.profile.api.ProfileConstants
import org.palladiosimulator.pcm.repository.OperationRequiredRole
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource
import org.palladiosimulator.pcm.seff.ExternalCallAction
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF
import org.palladiosimulator.pcm.system.System

import static org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.EMFUtils.*

import static extension org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance.createInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.Hash

class SEFFBehaviorTransformator extends BehaviorTransformator {
	
	new(TransformationFacilities transformationFacilities) {
		super(transformationFacilities)
	}
	
	override handleTransferOperation(PerformDataTransmissionOperation callerDataOperation, Operation caller, IdentifierInstance<DataOperation, AssemblyContext> callerInstance, Map<Data, LogicTerm> resultRefCache) {	
		val actionCandidates = getStereotypedElements(ProfileConstants.STEREOTYPE_NAME_DATA_PROCESSING, callerDataOperation.container, Entity)
		val targetSEFF = determineCalledSEFF(actionCandidates, callerInstance)			
				
		val ownAssemblyContext = callerInstance.identifier.get
		val targetAssemblyContext = targetSEFF.ac
				
		val ownResourceContainer = ownAssemblyContext.resourceContainer
		val targetResourceContainer = targetAssemblyContext.resourceContainer
		val allLinkingResources = ownResourceContainer.resourceEnvironment_ResourceContainer.linkingResources__ResourceEnvironment.filter(LinkingResource)
		
		val linkingResource = allLinkingResources
				.filter[lr | lr.connectedResourceContainers_LinkingResource.contains(ownResourceContainer) && lr.connectedResourceContainers_LinkingResource.contains(targetResourceContainer)]
				.findFirst[true]
					
		val targetDataOperation = targetSEFF.SEFFOperation
		val proxyDataOperation = factory.createOperation
		proxyDataOperation.name = '''DataTransmissionProxyOperation_«caller.name»_«targetDataOperation.name»'''
		transformationFacilities.system.operations += proxyDataOperation
		linkingResource.copyCharacteristicsTo(proxyDataOperation)
	
		val callerToProxyCall = factory.createOperationCall
		callerToProxyCall.name = Hash.init(caller.name).add(targetDataOperation.name).add('_callerToProxy').hash
		callerToProxyCall.caller = caller
		callerToProxyCall.callee = proxyDataOperation
		caller.calls += callerToProxyCall
		
		val proxyToTargetCall = factory.createOperationCall	
		proxyToTargetCall.name = Hash.init(caller.name).add(targetDataOperation.name).add('_proxyToTarget').hash			
		proxyToTargetCall.caller = proxyDataOperation
		proxyToTargetCall.callee = targetDataOperation
		proxyDataOperation.calls += proxyToTargetCall
		
		for (inputMapping : callerDataOperation.inputMappings) {
			val targetParameterData = inputMapping.to
			val targetStateVariable = targetParameterData.getStateVariable(targetSEFF)	
			
			// From Caller to Proxy
			val proxyStateVariable = factory.createVariable
			proxyStateVariable.name = '''DataTransmissionProxy_STATE_«linkingResource.entityName»_«inputMapping.id»'''
			proxyStateVariable.datatype = targetStateVariable.datatype
			
			proxyDataOperation.stateVariables += proxyStateVariable 
			
			// copy assignments from sourceReturnVariable to proxyStateVariable
			val sourceData = inputMapping.from			
			val proxyAssignment = factory.createVariableAssignment
			proxyAssignment.term = resultRefCache.get(sourceData)
			proxyAssignment.variable = proxyStateVariable
			callerToProxyCall.preCallStateDefinitions += proxyAssignment
			
			// From Proxy to Target			
			targetDataOperation.stateVariables += targetStateVariable
			
			val stateRef = factory.createStateRef
			stateRef.stateVariable = proxyStateVariable
			val targetAssignment = factory.createVariableAssignment
			targetAssignment.term = stateRef
			targetAssignment.variable = targetStateVariable
			proxyToTargetCall.preCallStateDefinitions += targetAssignment
		}
		
		for (outputMapping : callerDataOperation.outputMappings) {
			val targetReturnVariable = outputMapping.from.getReturnVariable(targetSEFF)
			
			val proxyReturnVariable = factory.createVariable
			proxyReturnVariable.name = '''DataTransmissionProxy_RETURN_«linkingResource.entityName»_«outputMapping.id»'''
			proxyReturnVariable.datatype = targetReturnVariable.datatype

			proxyDataOperation.returnValues += proxyReturnVariable
			
			// From Target to Proxy
			val targetResultRef = factory.createReturnValueRef
			targetResultRef.call = proxyToTargetCall
			targetResultRef.returnValue = targetReturnVariable
			
			val proxyAssignment = factory.createVariableAssignment
			proxyAssignment.term = targetResultRef
			proxyAssignment.variable = proxyReturnVariable
			
			proxyDataOperation.returnValueAssignments += proxyAssignment
			
			// From Proxy to Caller
			val selfReturnVariable = outputMapping.to.getReturnVariable(callerInstance)
			caller.returnValues += selfReturnVariable
	
			val proxyResultRef = factory.createReturnValueRef
			proxyResultRef.call = callerToProxyCall
			proxyResultRef.returnValue = proxyReturnVariable
	
			val callerAssignment = factory.createVariableAssignment
			callerAssignment.term = proxyResultRef
			callerAssignment.variable = selfReturnVariable
	
			caller.returnValueAssignments += callerAssignment
		}
	}
	
	private def determineCalledSEFF(Iterable<Entity> callAction, IdentifierInstance<? extends Entity, AssemblyContext> callerInstance) {
		val eca = callAction.filter(ExternalCallAction).findFirst[true]
		
		val calledOperationSignature = eca.calledService_ExternalService
		val calledInterface = calledOperationSignature.interface__OperationSignature
		
		val ownAssemblyContext = callerInstance.identifier.get
		val ownComponent = ownAssemblyContext.encapsulatedComponent__AssemblyContext
		val ownRoleCandidates = ownComponent.requiredRoles_InterfaceRequiringEntity.filter(OperationRequiredRole).filter[r | r.requiredInterface__OperationRequiredRole === calledInterface]
		
		val pcmSystem = getParentOfType(ownAssemblyContext, System).get
		val assemblyConnectorCandidates = pcmSystem.connectors__ComposedStructure.filter(AssemblyConnector).filter[c | c.requiringAssemblyContext_AssemblyConnector === ownAssemblyContext && ownRoleCandidates.exists[r | r === c.requiredRole_AssemblyConnector]]
		
		val targetSEFFCandidates = assemblyConnectorCandidates.map[providingAssemblyContext_AssemblyConnector].toSet.flatMap[findAllSEFFs].filter[s | s.entity.describedService__SEFF === calledOperationSignature]
		targetSEFFCandidates.findFirst[true]
	}
	
	override protected createReturnVariables(IdentifierInstance<? extends Identifier, AssemblyContext> behaviorIdentifier) {
		val seff = behaviorIdentifier.entity as ResourceDemandingSEFF
		val signature = seff.describedService__SEFF
		
		val signatureRefinement = tryGetTaggedValue(signature, ProfileConstants.TAGGED_VALUE_NAME_OPERATION_SIGNATURE_DATA_REFINEMENT, ProfileConstants.STEREOTYPE_NAME_OPERATION_SIGNATURE_DATA_REFINEMENT, OperationSignatureDataRefinement)
		signatureRefinement.map([sr | sr.resultRefinements.map[getReturnVariable(behaviorIdentifier)]]).orElse(#[])
	}
	
	override protected createStateVariables(IdentifierInstance<? extends Identifier, AssemblyContext> behaviorIdentifier) {
		val seff = behaviorIdentifier.entity as ResourceDemandingSEFF
		val signature = seff.describedService__SEFF
		val signatureRefinement = tryGetTaggedValue(signature, ProfileConstants.TAGGED_VALUE_NAME_OPERATION_SIGNATURE_DATA_REFINEMENT, ProfileConstants.STEREOTYPE_NAME_OPERATION_SIGNATURE_DATA_REFINEMENT, OperationSignatureDataRefinement)
		signatureRefinement.map([sr | sr.parameterRefinements.map[getStateVariable(behaviorIdentifier)]]).orElse(#[])
	}
	
	override protected findAllDataOps(Identifier identifier) {
		(identifier as ResourceDemandingSEFF).findAllDataOperations
	}
	
	override protected createReturnValueAssignmentsForConsumerOperations(DataOperation consumerDataOp, AssemblyContext selfAssemblyContext, IdentifierInstance<? extends Identifier, AssemblyContext> selfInstance, OperationCall consumerOpCall) {
		if (!(consumerDataOp instanceof ReturnDataOperation)) {
			return #[]
		}
		
		val returnOp = consumerDataOp as ReturnDataOperation
		
		val returnOpInstance = selfAssemblyContext.createInstance(returnOp)
		
		val returnOpData = returnOp.consumedData
		val seffReturnedData = returnOp.returnDestination
		
		val seffReturnVariable = seffReturnedData.getReturnVariable(selfInstance)
		val returnOpReturnVariable = returnOpData.getReturnVariable(returnOpInstance)
		
		val returnValueRef = factory.createReturnValueRef
		returnValueRef.call = consumerOpCall
		returnValueRef.returnValue = returnOpReturnVariable
		
		val returnVariableAssignment = factory.createVariableAssignment
		returnVariableAssignment.variable = seffReturnVariable
		returnVariableAssignment.term = returnValueRef
		
		#[returnVariableAssignment]
	}
	
	override protected getPropertySource(IdentifierInstance<? extends Identifier, AssemblyContext> instance) {
		instance.identifier.get.resourceContainer
	}
	
}