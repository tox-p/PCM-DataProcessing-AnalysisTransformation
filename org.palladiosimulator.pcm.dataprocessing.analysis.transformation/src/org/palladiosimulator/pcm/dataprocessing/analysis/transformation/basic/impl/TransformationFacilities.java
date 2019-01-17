package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

import edu.kit.ipd.sdq.dataflow.systemmodel.Caller;
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm;
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation;
import edu.kit.ipd.sdq.dataflow.systemmodel.OperationCall;
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable;
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment;

public interface TransformationFacilities {

	edu.kit.ipd.sdq.dataflow.systemmodel.System getSystem();

	Operation getOperation(IdentifierInstance<DataOperation, AssemblyContext> dataOpInstance);
	
	Operation getOperation(IdentifierInstance<DataOperation, AssemblyContext> dataOpInstance, EObject propertySource);

	Operation getSEFFOperation(SEFFInstance seffInstance);

	OperationCall getOperationCall(Caller from, Operation to);

	Variable getReturnVariable(Data data, IdentifierInstance<?, ?> instance);

	Variable getStateVariable(Data data, IdentifierInstance<?, ?> instance);

	List<VariableAssignment> createReturnValueAssignments(IdentifierInstance<DataOperation, AssemblyContext> opInstance,
			Map<Data, LogicTerm> availableData);

	ResourceContainer getResourceContainer(AssemblyContext ac);
	
	void copyCharacteristicsTo(LinkingResource lr, Operation op);
}
