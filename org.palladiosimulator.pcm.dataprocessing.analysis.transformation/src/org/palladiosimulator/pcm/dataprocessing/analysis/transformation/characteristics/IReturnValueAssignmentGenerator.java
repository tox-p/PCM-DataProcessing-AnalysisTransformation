package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation;

import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm;
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable;
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment;

public interface IReturnValueAssignmentGenerator extends IPrioritizable {

	List<VariableAssignment> generateAssignments(IQueryExecutor queryExecutor, Optional<AssemblyContext> ac, DataOperation dataOperation,
			Map<Data, LogicTerm> availableData, Map<Data, Variable> returnVariables);

}
