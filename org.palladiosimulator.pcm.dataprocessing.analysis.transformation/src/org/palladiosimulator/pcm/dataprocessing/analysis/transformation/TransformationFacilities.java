package org.palladiosimulator.pcm.dataprocessing.analysis.transformation;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation;

import edu.kit.ipd.sdq.dataflow.systemmodel.Caller;
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm;
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation;
import edu.kit.ipd.sdq.dataflow.systemmodel.OperationCall;
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable;
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment;

public interface TransformationFacilities {

	edu.kit.ipd.sdq.dataflow.systemmodel.System getSystem();

	Operation getOperation(IdentifierInstance<DataOperation, ?> dataOpInstance);

	Operation getSEFFOperation(SEFFInstance seffInstance);

	OperationCall getOperationCall(Caller from, Operation to);

	Variable getReturnVariable(Data data, IdentifierInstance<?, ?> instance);

	Variable getStateVariable(Data data, IdentifierInstance<?, ?> instance);

	List<VariableAssignment> createReturnValueAssignments(IdentifierInstance<DataOperation, ?> opInstance,
			Map<Data, LogicTerm> availableData);

}
