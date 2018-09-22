package org.palladiosimulator.pcm.dataprocessing.analysis.transformation

import edu.kit.ipd.sdq.dataflow.systemmodel.Caller
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Delegate
import org.palladiosimulator.pcm.allocation.Allocation
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.Hash
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicType
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicLiteral
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicType
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.CreateDataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ReturnDataOperation
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.system.System
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour
import org.palladiosimulator.pcm.usagemodel.UsageModel

import static org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance.*

class PCM2DFSystemModelTransformation implements PCM2IntermediateModelTransformator, TransformationFacilities {
	
	static val factory = SystemModelFactory.eINSTANCE
	val extension UniqueNameProvider uniqueNameProvider = new CachedUniqueNameProvider()
	
	override transform(UsageModel pcmUsageModel, System pcmSystem, Allocation pcmAllocationModel, CharacteristicTypeContainer pcmCharacteristicTypeContainer) {
		system.name = pcmSystem.entityName
		system.types += pcmCharacteristicTypeContainer.characteristicTypes.map[valueType]
		system.operations += BehaviorTransformator.findAllSEFFs(pcmSystem).map[getSEFFOperation]
		system.systemusages += pcmUsageModel.usageScenario_UsageModel.map[scenarioBehaviour_UsageScenario].map[getSystemUsage]
		system
	}
	
	// TRANSFORMATION: n/a -> System
	override create sys: factory.createSystem getSystem() {
		
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
		
		val delegateOperation = scenarioBehavior.systemUsageDataOperation
		system.operations += delegateOperation
		sysUsage.calls += sysUsage.getOperationCall(delegateOperation)
		
		// we just do one call to the operation and do not pass any information
	}
	
	// TRANSFORMATION: ScenarioBehaviour -> Operation
	protected def create sysUsageDataOp: factory.createOperation getSystemUsageDataOperation(ScenarioBehaviour scenarioBehavior) {
		sysUsageDataOp.name = scenarioBehavior.uniqueName + "_dataOp"
		
		val transformator = new UsageModelBehaviorTransformator(this)
		transformator.transformBehavior(sysUsageDataOp, createInstance(null, scenarioBehavior))
	}
	
	// TRANSFORMATION: SEFFInstance -> Operation
	override create op: factory.createOperation getSEFFOperation(SEFFInstance seffInstance) {
		op.name = seffInstance.uniqueName
		
		val transformator = new SEFFBehaviorTransformator(this)
		transformator.transformBehavior(op, seffInstance)
	}
	
	// TRANSFORMATION: SEFFInstance, DataOperation -> Operation
	override create op: factory.createOperation getOperation(IdentifierInstance<DataOperation, ?> dataOpInstance) {
		op.name = dataOpInstance.uniqueName
		
		// we never have input parameters
		// we might use state variables but we have to handle this later
		
		// create return variables in current operation (containment)
		var outgoingData = dataOpInstance.entity.outgoingData + #[dataOpInstance.entity].filter(ReturnDataOperation).flatMap[incomingData]
		op.returnValues += outgoingData.map[getReturnVariable(dataOpInstance)]
		
		// we have to determine calls later
	}

	// TRANSFORMATION: SEFFInstance, Operation/Operation -> OperationCall
	override create opCall: factory.createOperationCall getOperationCall(Caller from, Operation to) {
		opCall.caller = from
		opCall.callee = to
		opCall.name = 'opCall_' + Hash.init(from.name).add(to.name).hash
	}

	// TRANSFORMATION: Data -> Variable
	override getStateVariable(Data data, IdentifierInstance<?, ?> instance) {
		data.getVariable(VariablePurpose.STATE, instance)
	}
	
	protected def getParameterVariable(Data data, IdentifierInstance<?, ?> instance) {
		data.getVariable(VariablePurpose.PARAMETER, instance)
	}
	
	override getReturnVariable(Data data, IdentifierInstance<?, ?> instance) {
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
	
	
	
	
	// Assignment suff (analysis magic happens here)
	
	override createReturnValueAssignments(IdentifierInstance<DataOperation, ?> opInstance, Map<Data, LogicTerm> availableData) {
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

}