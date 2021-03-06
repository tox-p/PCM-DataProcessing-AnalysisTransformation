package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.rbac.characteristics

import edu.kit.ipd.sdq.dataflow.systemmodel.Attribute
import edu.kit.ipd.sdq.dataflow.systemmodel.DefaultStateRef
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.ParameterRef
import edu.kit.ipd.sdq.dataflow.systemmodel.PropertyRef
import edu.kit.ipd.sdq.dataflow.systemmodel.ReturnValueRef
import edu.kit.ipd.sdq.dataflow.systemmodel.StateRef
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory
import edu.kit.ipd.sdq.dataflow.systemmodel.Value
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment
import java.util.ArrayList
import java.util.List
import java.util.Map
import java.util.Optional
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.IQueryExecutor
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ManyToOneDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.TransformDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.util.ProcessingSwitch

class DataProcessorSwitch extends ProcessingSwitch<List<VariableAssignment>> {

	static extension val SystemModelFactory factory = SystemModelFactory.eINSTANCE
	val IQueryExecutor queryExecutor
	val Optional<AssemblyContext> ac
	val Map<Data, LogicTerm> availableData
	val Map<Data, Variable> returnVariables
	val String characteristicNameRoles
	val String characteristicNameAccessRights

	new(IQueryExecutor queryExecutor, Optional<AssemblyContext> ac, Map<Data, LogicTerm> availableData,
		Map<Data, Variable> returnVariables, String characteristicNameRoles, String characteristicNameAccessRights) {
		this.queryExecutor = queryExecutor
		this.ac = ac
		this.availableData = availableData
		this.returnVariables = returnVariables
		this.characteristicNameRoles = characteristicNameRoles
		this.characteristicNameAccessRights = characteristicNameAccessRights
	}
	
	/**
	 * When joining data or creating the union, the set of access rights is the
	 * intersection of the access rights of the inputs. An access right is only
	 * set, if the particular access right is set on all incoming data. 
	 */
	override caseManyToOneDataOperation(ManyToOneDataOperation op) {
		val relevantCharacteristicType = queryExecutor.characteristicTypes.findFirst[ct | ct.entityName == characteristicNameAccessRights]
		val values = queryExecutor.getValues(relevantCharacteristicType)

		val result = new ArrayList<VariableAssignment>()

		for (returnVariable : returnVariables.entrySet) { // should be exactly one
			val attribute = queryExecutor.getAttribute(relevantCharacteristicType)
			//TODO try to avoid generating assignments for single values
			for (value : values) {
				val assignment = createVariableAssignment
				assignment.variable = returnVariable.value
				assignment.attribute = attribute
				assignment.value = value
				val term = createAnd
				for (inputTerm : op.consumedData.map[d | availableData.get(d)]) {
					val inputTermCopy = EcoreUtil.copy(inputTerm)
					inputTermCopy.setAttributeAndValue(attribute, value)
					term.operands += inputTermCopy
				}
				assignment.term = term
				result += assignment
			}
		}
		
		result
	}
	
	override caseTransformDataOperation(TransformDataOperation op) {
		// special handling might be useful to reflect changing privacy levels depending on operation and data
		op.defaultCase
	}

	override defaultCase(EObject obj) {
		#[]
	}
	
	protected static def dispatch setAttributeAndValue(ReturnValueRef ref, Attribute attribute, Value value) {
		ref.attribute = attribute
		ref.value = value
	}
	
	protected static def dispatch setAttributeAndValue(StateRef ref, Attribute attribute, Value value) {
		ref.attribute = attribute
		ref.value = value
	}
	
	protected static def dispatch setAttributeAndValue(DefaultStateRef ref, Attribute attribute, Value value) {
		ref.attribute = attribute
		ref.value = value
	}
	
	protected static def dispatch setAttributeAndValue(ParameterRef ref, Attribute attribute, Value value) {
		ref.attribute = attribute
		ref.value = value
	}
	
	protected static def dispatch setAttributeAndValue(PropertyRef ref, Attribute attribute, Value value) {
		// do not set attribute
		ref.value = value
	}
	
	protected static def dispatch setAttributeAndValue(LogicTerm term, Attribute attribute, Value value) {
		// do nothing
	}
	
}
