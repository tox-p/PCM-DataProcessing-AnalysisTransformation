package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.impl

import com.google.common.base.Supplier
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment
import java.util.ArrayList
import java.util.List
import java.util.Map
import java.util.Optional
import org.osgi.service.component.annotations.Component
import org.palladiosimulator.mdsdprofiles.api.StereotypeAPI
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.IQueryExecutor
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.IReturnValueAssignmentGenerator
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.EMFUtils
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.Characteristic
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicType
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.StoreCharacteristicContainer
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.effectspecification.CharacteristicSpecification
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.effectspecification.DirectCharacteristic
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.CharacteristicChangeOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.CharacteristicChangingDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.CreateDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.LoadDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ProcessingEffectOperationTypeSpecifyingOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ReturnDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.TransformDataOperation
import org.palladiosimulator.pcm.dataprocessing.profile.api.ProfileConstants

import static org.apache.commons.lang3.Validate.*

@Component
class DefaultReturnValueAssignmentGenerator implements IReturnValueAssignmentGenerator {
	
	static extension val SystemModelFactory factory = SystemModelFactory.eINSTANCE
	
	override getProducedType() {
		ProducedAssignmentType.DEFAULTS
	}
	
	override generateAssignments(IQueryExecutor queryExecutor, Optional<AssemblyContext> ac, DataOperation dataOperation, Map<Data, LogicTerm> availableData, Map<Data, Variable> returnVariables) {
		notNull(queryExecutor)
		notNull(dataOperation)
		notNull(availableData)
		notNull(returnVariables)
		val result = new ArrayList<VariableAssignment>()
		result += dataOperation.generateAssignmentsInternal(queryExecutor, ac, availableData, returnVariables)
		if (dataOperation instanceof ProcessingEffectOperationTypeSpecifyingOperation) {
			result += dataOperation.generateUserDefinedProcessingEffectAssignments(queryExecutor, ac, availableData, returnVariables)			
		}
		result
	}
	
	protected def dispatch generateAssignmentsInternal(DataOperation dataOperation, IQueryExecutor queryExecutor, Optional<AssemblyContext> ac, Map<Data, LogicTerm> availableData, Map<Data, Variable> returnVariables) {
		// default case: generate single assignments for each operation
		val result = new ArrayList<VariableAssignment>()
		for (data : returnVariables.keySet.sortBy[id]) {
			val returnVariable = data -> returnVariables.get(data)
			notNull(returnVariable.key)
			notNull(returnVariable.value)
			result += dataOperation.generate(returnVariable, availableData, queryExecutor, ac)
		}
		result
	}
	
	protected def dispatch generateAssignmentsInternal(TransformDataOperation dataOperation, IQueryExecutor queryExecutor, Optional<AssemblyContext> ac, Map<Data, LogicTerm> availableData, Map<Data, Variable> returnVariables) {
		val returnVariable = returnVariables.get(dataOperation.output)
		val logicTerm = availableData.get(dataOperation.input)
		#[createCopyAssignment(returnVariable, logicTerm)]
	}
	
	protected def dispatch generate(DataOperation dataOperation, Pair<Data, Variable> returnVariable, Map<Data, LogicTerm> availableData, IQueryExecutor queryExecutor, Optional<AssemblyContext> ac) {
		/*
		 * CharacteristicChangingDataOperation: see implementation
		 * ConsumeDataOperation: no action needed (except for ReturnDataOperation)
		 * CreateDataOperation: disable all properties and copy initial characteristics
		 * LoadDataOperation: disable all properties and copy default characteristics
		 * ManyToOneDataOperation: default handling not possible
		 * PerformDataTransmissionOperation: already handled in behaviour transformation
		 * TransformDataOperation: see implementation
		 */
		
		#[]
	}
	
	protected def dispatch generate(ReturnDataOperation dataOperation, Pair<Data, Variable> returnVariable, Map<Data, LogicTerm> availableData, IQueryExecutor queryExecutor, Optional<AssemblyContext> ac) {
		val variable = returnVariable.value
		val term = availableData.get(returnVariable.key)
		#[createCopyAssignment(variable, term)]
	}
	
	protected def dispatch generate(CharacteristicChangingDataOperation<?> dataOperation, Pair<Data, Variable> returnVariable, Map<Data, LogicTerm> availableData, IQueryExecutor queryExecutor, Optional<AssemblyContext> ac) {
		val result = new ArrayList<VariableAssignment>()
		val variable = returnVariable.value
		
		// always: copy all characteristics from input to output
		result += createCopyAssignment(variable, availableData.get(returnVariable.key))
		
		result += variable.createChangeAssignments(dataOperation.operation, queryExecutor, dataOperation.characteristic, dataOperation.characteristic.characteristicType)
		result
	}
	
	protected def dispatch generate(CreateDataOperation dataOperation, Pair<Data, Variable> returnVariable, Map<Data, LogicTerm> availableData, extension IQueryExecutor queryExecutor, Optional<AssemblyContext> ac) {
		returnVariable.value.createAssignments(dataOperation.initialCharacteristics, queryExecutor)
	}
	
	protected def dispatch generate(LoadDataOperation dataOperation, Pair<Data, Variable> returnVariable, Map<Data, LogicTerm> availableData, extension IQueryExecutor queryExecutor, Optional<AssemblyContext> ac) {
		// copy default characteristics if existing
		if (!StereotypeAPI.hasAppliedStereotype(#{ac.get}, ProfileConstants.STEREOTYPE_NAME_STORE_CHARACTERIZATION)) {
			return #[]
		}

		val variable = returnVariable.value
		val defaultCharacteristicContainer = EMFUtils.getTaggedValue(ac.get, ProfileConstants.TAGGED_VALUE_NAME_STORE_CHARACTERIZATION, ProfileConstants.STEREOTYPE_NAME_STORE_CHARACTERIZATION, StoreCharacteristicContainer)
		val defaultCharacteristics = defaultCharacteristicContainer.characteristics.findFirst[c | c.store === dataOperation.store]
		
		variable.createAssignments(defaultCharacteristics.ownedCharacteristics, queryExecutor)
	}
//	
//	protected def dispatch generate(TransformDataOperation dataOperation, Pair<Data, Variable> returnVariable, Map<Data, LogicTerm> availableData, IQueryExecutor queryExecutor, Optional<AssemblyContext> ac) {
//		// copy everything from input to output while ignoring parameter data
//		#[createCopyAssignment(returnVariable.value, availableData.get(dataOperation.input))]
//	}
	
	
		
	protected def List<VariableAssignment> generateUserDefinedProcessingEffectAssignments(ProcessingEffectOperationTypeSpecifyingOperation dataOperation, IQueryExecutor queryExecutor, Optional<AssemblyContext> ac, Map<Data, LogicTerm> availableData, Map<Data, Variable> returnVariables) {
		val result = new ArrayList<VariableAssignment>()
		
		for (returnVariableEntry : returnVariables.entrySet) {
			val returnData = returnVariableEntry.key
			val returnVariable = returnVariableEntry.value
			
			val relevantProcessingEffects = dataOperation.processingEffectProvider.processingEffects.filter[isApplicableTo(dataOperation, returnData)]
			for (characteristicChange : relevantProcessingEffects.map[characteristicChanges].flatten) {
				
				for (changeSpecification : characteristicChange.characteristicSpecifications) {
					result += changeSpecification.createChangeAssignmentsBySpecification(returnVariable, queryExecutor)
				}
				
			}
		}
		
		result
	}
	
	protected def dispatch createChangeAssignmentsBySpecification(DirectCharacteristic spec, Variable returnVariable, IQueryExecutor queryExecutor) {
		val changeOperation = spec.characteristicChange.changeOperation
		val sourceCharacteristic = spec.characteristic
		returnVariable.createChangeAssignments(changeOperation, queryExecutor, sourceCharacteristic, sourceCharacteristic.characteristicType)
		
	}
	
	protected def dispatch createChangeAssignmentsBySpecification(CharacteristicSpecification spec, Variable returnVariable, IQueryExecutor queryExecutor) {
		#[]
	}
	
	
	protected static def createChangeAssignments(Variable variable, CharacteristicChangeOperation changeOperation, IQueryExecutor queryExecutor, Characteristic sourceCharacteristic, CharacteristicType targetCharacteristicType) {
		val result = new ArrayList<VariableAssignment>()
		
		val sourceAttribute = queryExecutor.getAttribute(sourceCharacteristic.characteristicType)
		notNull(sourceAttribute)
		val targetAttribute = queryExecutor.getAttribute(targetCharacteristicType)
		notNull(targetAttribute)
		
		// copy has to take place before

		// replace: set all values related to the characteristic to false
		if (changeOperation === CharacteristicChangeOperation.REPLACE) {
			
			val resetAssignment = createVariableAssignment
			resetAssignment.variable = variable
			resetAssignment.attribute = targetAttribute
			resetAssignment.term = createFalse
			result += resetAssignment
		}
		
		// always: set values mentioned in the operation
		val Supplier<LogicTerm> termProvider = if (changeOperation === CharacteristicChangeOperation.REMOVE) [createFalse] else [createTrue]
		val values = queryExecutor.getValues(sourceCharacteristic)
		notNull(values)
		for (value : values) {
			val changeAssignment = createVariableAssignment
			changeAssignment.variable = variable
			changeAssignment.attribute = targetAttribute
			changeAssignment.value = value
			changeAssignment.term = termProvider.get
			result += changeAssignment
		}

		result
	}
	
	protected static def createAssignments(Variable variable, Iterable<Characteristic> characteristics, extension IQueryExecutor queryExecutor) {
		val result = new ArrayList<VariableAssignment>()
		
		val falseAssignment = createVariableAssignment
		falseAssignment.variable = variable
		falseAssignment.term = createFalse
		result += falseAssignment
		
		for (characteristic : characteristics) {
			val attribute = characteristic.characteristicType.attribute
			for (value : characteristic.values) {
				val changeAssignment = createVariableAssignment
				changeAssignment.variable = variable
				changeAssignment.attribute = attribute
				changeAssignment.value = value
				changeAssignment.term = createTrue
				result += changeAssignment
			}
		}
		result
	}
	
	protected static def createCopyAssignment(Variable destination, LogicTerm assignment) {
		notNull(destination)
		notNull(assignment)
		val copyAssignment = createVariableAssignment
		copyAssignment.variable = destination
		copyAssignment.term = assignment
		copyAssignment
	}
	
}