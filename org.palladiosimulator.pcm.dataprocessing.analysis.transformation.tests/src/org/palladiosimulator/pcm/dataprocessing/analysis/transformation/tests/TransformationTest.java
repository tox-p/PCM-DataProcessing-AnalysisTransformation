package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.IReturnValueAssignmentGenerator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests.base.TransformationTestBase;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer;
import org.palladiosimulator.pcm.usagemodel.UsageModel;

import edu.kit.ipd.sdq.dataflow.systemmodel.Operation;
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable;
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment;

public class TransformationTest extends TransformationTestBase {

	public TransformationTest() {
		super("org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests");
	}

	@Override
	protected Collection<IReturnValueAssignmentGenerator> getAdditionalGenerators() {
		return Collections.emptyList();
	}

	@Test
	public void testMinimalEcho() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		UsageModel usageModel = (UsageModel) rs
				.getResource(createRelativeURI("models/minimalCallAndReturn/newUsageModel.usagemodel"), true)
				.getContents().get(0);
		org.palladiosimulator.pcm.system.System system = (org.palladiosimulator.pcm.system.System) rs
				.getResource(createRelativeURI("models/minimalCallAndReturn/newSystem.system"), true).getContents()
				.get(0);
		Allocation allocationModel = (Allocation) rs
				.getResource(createRelativeURI("models/minimalCallAndReturn/newAllocation.allocation"), true)
				.getContents().get(0);
		CharacteristicTypeContainer characteristicTypeContainer = (CharacteristicTypeContainer) rs
				.getResource(createRelativeURI("models/minimalCallAndReturn/characteristicTypes.xmi"), true)
				.getContents().get(0);
		EcoreUtil.resolveAll(rs);

		edu.kit.ipd.sdq.dataflow.systemmodel.System dataFlowSystemModel = getSubject().transform(usageModel, system,
				allocationModel, characteristicTypeContainer);

		Diagnostic validationResult = Diagnostician.INSTANCE.validate(dataFlowSystemModel);
		assertThat(toString(validationResult), validationResult.getSeverity(), is(Diagnostic.OK));

		assertThat(dataFlowSystemModel.getSystemusages(), hasSize(1));
		assertThat(dataFlowSystemModel.getSystemusages().get(0).getCalls(), hasSize(1));

		Operation systemUsageOperation = dataFlowSystemModel.getSystemusages().get(0).getCalls().get(0).getCallee();
		assertThat(systemUsageOperation.getCalls(), hasSize(1));

		Operation consumeOperation = systemUsageOperation.getCalls().get(0).getCallee();
		assertThat(consumeOperation.getReturnValues(), is(empty()));
		assertThat(consumeOperation.getCalls(), hasSize(1));

		Operation transmitOperation = consumeOperation.getCalls().get(0).getCallee();
		assertThat(transmitOperation.getReturnValues(), hasSize(1));
		assertThat(transmitOperation.getCalls(), hasSize(2));
		assertThat(transmitOperation.getCalls().get(1).getPreCallStateDefinitions(), hasSize(1));
		assertThat(transmitOperation.getReturnValueAssignments(), hasSize(1));

		Operation createOperation = transmitOperation.getCalls().get(0).getCallee();
		assertThat(createOperation.getCalls(), is(empty()));
		assertThat(createOperation.getReturnValues(), hasSize(1));
		assertThat(createOperation.getReturnValueAssignments(), hasSize(1));

		Operation seffOperation = transmitOperation.getCalls().get(1).getCallee();
		assertThat(seffOperation.getReturnValues(), hasSize(1));
		assertThat(seffOperation.getStateVariables(), hasSize(1));
		assertThat(seffOperation.getParameters(), hasSize(0));
		assertThat(seffOperation.getReturnValueAssignments(), hasSize(1));
		assertThat(seffOperation.getCalls(), hasSize(1));

		Variable createdEchoDataVariable = createOperation.getReturnValues().get(0);
		VariableAssignment stateDef = transmitOperation.getCalls().get(1).getPreCallStateDefinitions().get(0);
		assertFullCopy(stateDef, seffOperation.getStateVariables().get(0), createdEchoDataVariable,
				transmitOperation.getCalls().get(0));

		Operation echoOperation = seffOperation.getCalls().get(0).getCallee();
		assertThat(echoOperation.getReturnValues(), hasSize(1));
		assertThat(echoOperation.getReturnValueAssignments(), hasSize(1));
		assertThat(echoOperation.getCalls(), is(empty()));
		assertThat(echoOperation.getParameters(), is(empty()));

		VariableAssignment echoOperationReturnAssignment = echoOperation.getReturnValueAssignments().get(0);
		assertFullCopy(echoOperationReturnAssignment, echoOperation.getReturnValues().get(0),
				seffOperation.getStateVariables().get(0));

		VariableAssignment seffReturnAssignment = seffOperation.getReturnValueAssignments().get(0);
		assertFullCopy(seffReturnAssignment, seffOperation.getReturnValues().get(0),
				echoOperation.getReturnValues().get(0), seffOperation.getCalls().get(0));

		VariableAssignment transmitOperationReturnAssignment = transmitOperation.getReturnValueAssignments().get(0);
		assertFullCopy(transmitOperationReturnAssignment, transmitOperation.getReturnValues().get(0),
				seffOperation.getReturnValues().get(0), transmitOperation.getCalls().get(1));

//		Resource r = rs.createResource(createRelativeURI("models/minimalCallAndReturn/result.xmi"));
//		r.getContents().add(dataFlowSystemModel);
//		r.save(Collections.emptyMap());
	}
	
	@Test
	public void testMinimalSameSignature() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		UsageModel usageModel = (UsageModel) rs
				.getResource(createRelativeURI("models/minimalSameSignature/newUsageModel.usagemodel"), true)
				.getContents().get(0);
		org.palladiosimulator.pcm.system.System system = (org.palladiosimulator.pcm.system.System) rs
				.getResource(createRelativeURI("models/minimalSameSignature/newAssembly.system"), true).getContents()
				.get(0);
		Allocation allocationModel = (Allocation) rs
				.getResource(createRelativeURI("models/minimalSameSignature/newAllocation.allocation"), true)
				.getContents().get(0);
		CharacteristicTypeContainer characteristicTypeContainer = (CharacteristicTypeContainer) rs
				.getResource(createRelativeURI("models/minimalSameSignature/characteristicTypes.xmi"), true)
				.getContents().get(0);
		EcoreUtil.resolveAll(rs);

		edu.kit.ipd.sdq.dataflow.systemmodel.System dataFlowSystemModel = getSubject().transform(usageModel, system,
				allocationModel, characteristicTypeContainer);

		Diagnostic validationResult = Diagnostician.INSTANCE.validate(dataFlowSystemModel);
		assertThat(toString(validationResult), validationResult.getSeverity(), is(Diagnostic.OK));
		
		Resource expectedResource = rs.getResource(createRelativeURI("models/minimalSameSignature/expected.xmi"), true);
		
		IComparisonScope scope = new DefaultComparisonScope(expectedResource.getContents().get(0), dataFlowSystemModel, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		assertThat(toString(comparison), comparison.getDifferences(), is(empty()));
	}
	
	@Test
	public void testSecureLinksMinimal() throws Exception {
		ResourceSet rs = new ResourceSetImpl();

		UsageModel usageModel = (UsageModel) rs
				.getResource(createRelativeURI("models/secure-links-minimal/default.usagemodel"), true)
				.getContents()
				.get(0);
		
		org.palladiosimulator.pcm.system.System system = (org.palladiosimulator.pcm.system.System) rs
				.getResource(createRelativeURI("models/secure-links-minimal/default.system"), true)
				.getContents()
				.get(0);
		
		Allocation allocationModel = (Allocation) rs
				.getResource(createRelativeURI("models/secure-links-minimal/default.allocation"), true)
				.getContents()
				.get(0);
		
		CharacteristicTypeContainer characteristicTypeContainer = (CharacteristicTypeContainer) rs
				.getResource(createRelativeURI("models/secure-links-minimal/characteristicTypes.xmi"), true)
				.getContents()
				.get(0);
		
		EcoreUtil.resolveAll(rs);

		edu.kit.ipd.sdq.dataflow.systemmodel.System dataFlowSystemModel = getSubject().transform(
				usageModel, system, allocationModel, characteristicTypeContainer);

		Diagnostic validationResult = Diagnostician.INSTANCE.validate(dataFlowSystemModel);
		assertThat(toString(validationResult), validationResult.getSeverity(), is(Diagnostic.OK));
		
//		Resource r = rs.createResource(createRelativeURI("models/secure-links-minimal/expected.xmi"));
//		r.getContents().add(dataFlowSystemModel);
//		r.save(Collections.emptyMap());
		
		Resource expectedResource = rs.getResource(createRelativeURI("models/secure-links-minimal/expected.xmi"), true);
		
		IComparisonScope scope = new DefaultComparisonScope(expectedResource.getContents().get(0), dataFlowSystemModel, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		
		assertThat(toString(comparison), comparison.getDifferences(), is(empty()));
	}
	
	@Test
	public void testSecureLinksComplex() throws Exception {
		ResourceSet rs = new ResourceSetImpl(); 
 
		UsageModel usageModel = (UsageModel) rs
				.getResource(createRelativeURI("models/secure-links-complex/default.usagemodel"), true)
				.getContents()
				.get(0);
		
		org.palladiosimulator.pcm.system.System system = (org.palladiosimulator.pcm.system.System) rs
				.getResource(createRelativeURI("models/secure-links-complex/default.system"), true)
				.getContents()
				.get(0);
		
		Allocation allocationModel = (Allocation) rs
				.getResource(createRelativeURI("models/secure-links-complex/default.allocation"), true)
				.getContents()
				.get(0);
		
		CharacteristicTypeContainer characteristicTypeContainer = (CharacteristicTypeContainer) rs
				.getResource(createRelativeURI("models/secure-links-complex/characteristicTypes.xmi"), true)
				.getContents()
				.get(0);
		
		EcoreUtil.resolveAll(rs); 

		edu.kit.ipd.sdq.dataflow.systemmodel.System dataFlowSystemModel = getSubject().transform(
				usageModel, system, allocationModel, characteristicTypeContainer);

		Diagnostic validationResult = Diagnostician.INSTANCE.validate(dataFlowSystemModel);
		assertThat(toString(validationResult), validationResult.getSeverity(), is(Diagnostic.OK));
		
//		Resource r = rs.createResource(createRelativeURI("models/secure-links-complex/expected.xmi"));
//		r.getContents().add(dataFlowSystemModel);
//		r.save(Collections.emptyMap());
		
		Resource expectedResource = rs.getResource(createRelativeURI("models/secure-links-complex/expected.xmi"), true);
		
		IComparisonScope scope = new DefaultComparisonScope(expectedResource.getContents().get(0), dataFlowSystemModel, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		
		assertThat(toString(comparison), comparison.getDifferences(), is(empty()));
	}
}
