package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.rbac.tests;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.IReturnValueAssignmentGenerator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.rbac.characteristics.RBACReturnValueAssignmentGenerator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests.base.TransformationTestBase;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer;
import org.palladiosimulator.pcm.usagemodel.UsageModel;

import edu.kit.ipd.sdq.dataflow.systemmodel.Operation;
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable;
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment;

public class TransformationTest extends TransformationTestBase {

	public TransformationTest() {
		super("org.palladiosimulator.pcm.dataprocessing.analysis.transformation.rbac.tests");
	}

	@Override
	protected Collection<IReturnValueAssignmentGenerator> getAdditionalGenerators() {
		return Arrays.asList(new RBACReturnValueAssignmentGenerator());
	}
	
	@Test
	public void testTravelPlannerSuccess() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		UsageModel usageModel = (UsageModel) rs
				.getResource(createRelativeURI("models/travelPlanner/default.usagemodel"), true)
				.getContents().get(0);
		org.palladiosimulator.pcm.system.System system = (org.palladiosimulator.pcm.system.System) rs
				.getResource(createRelativeURI("models/travelPlanner/default.system"), true).getContents()
				.get(0);
		Allocation allocationModel = (Allocation) rs
				.getResource(createRelativeURI("models/travelPlanner/default.allocation"), true)
				.getContents().get(0);
		CharacteristicTypeContainer characteristicTypeContainer = (CharacteristicTypeContainer) rs
				.getResource(createRelativeURI("models/travelPlanner/characteristicTypes.xmi"), true)
				.getContents().get(0);
		EcoreUtil.resolveAll(rs);
		
		edu.kit.ipd.sdq.dataflow.systemmodel.System dataFlowSystemModel = getSubject().transform(usageModel, system,
				allocationModel, characteristicTypeContainer);
		
		Resource r = rs.createResource(createRelativeURI("models/travelPlanner/result.xmi"));
		r.getContents().add(dataFlowSystemModel);
		r.save(Collections.emptyMap());
	}

}
