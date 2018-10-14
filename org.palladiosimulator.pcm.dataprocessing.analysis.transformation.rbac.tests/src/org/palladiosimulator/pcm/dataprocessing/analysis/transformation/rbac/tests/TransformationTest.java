package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.rbac.tests;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.IReturnValueAssignmentGenerator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.rbac.characteristics.RBACReturnValueAssignmentGenerator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests.base.TransformationTestBase;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer;
import org.palladiosimulator.pcm.usagemodel.UsageModel;

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
		
		EObject expected = rs.getResource(createRelativeURI("models/travelPlanner/expected.xmi"), true).getContents().get(0);
		
		EObject actual = getSubject().transform(usageModel, system,
				allocationModel, characteristicTypeContainer);

		IComparisonScope scope = new DefaultComparisonScope(expected, actual, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		assertThat(toString(comparison), comparison.getDifferences(), is(empty()));
		
//		Resource r = rs.createResource(createRelativeURI("models/travelPlanner/result.xmi"));
//		r.getContents().add(actual);
//		r.save(Collections.emptyMap());
	}

}
