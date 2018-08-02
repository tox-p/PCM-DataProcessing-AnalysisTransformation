package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.modelversioning.emfprofile.Profile;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.PCM2DFSystemModelTransformation;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.PCM2IntermediateModelTransformator;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer;
import org.palladiosimulator.pcm.dataprocessing.profile.api.Api;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.pcm.usagemodel.UsageModel;


public class TransformationTest {

	private static final boolean PLUGIN_TEST = EcorePlugin.IS_ECLIPSE_RUNNING;
	private PCM2IntermediateModelTransformator subject;

	@BeforeClass
	public static void init() {
		if (!PLUGIN_TEST) {
			initStandalone();
		}
	}
	
	protected static void initStandalone() {
		// Detection of Meta Models and URIs by classpath magic
		// https://wiki.eclipse.org/EMF/FAQ#How_do_I_make_my_EMF_standalone_application_Eclipse-aware.3F
		EcorePlugin.ExtensionProcessor.process(null);

		// OCL Pivot
		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();

		// Resource URI Mapping
		registerProjectURI(Api.class, "org.palladiosimulator.pcm.dataprocessing.profile");
		registerProjectURI(TransformationTest.class, "org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests");
		
		// PCM Data Profile
		ResourceSet rs = new ResourceSetImpl();
		URI profileURI = createProjectRelativeURI("org.palladiosimulator.pcm.dataprocessing.profile", "profile.emfprofile_diagram");
		Profile profile = (Profile)rs.getResource(profileURI, true).getContents().get(0);
		EPackageRegistryImpl.INSTANCE.put(profile.getNsURI(), profile);
	}
	
	@Before
	public void setup() {
		subject = new PCM2DFSystemModelTransformation();
	}
	
	@Test
	@Ignore
	public void test() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		UsageModel usageModel = (UsageModel)rs.getResource(createRelativeURI("models/travelPlanner/default.usagemodel"), true).getContents().get(0);
		System system = (org.palladiosimulator.pcm.system.System)rs.getResource(createRelativeURI("models/travelPlanner/default.system"), true).getContents().get(0);
		Allocation allocationModel = (Allocation)rs.getResource(createRelativeURI("models/travelPlanner/default.allocation"), true).getContents().get(0);
		CharacteristicTypeContainer characteristicTypeContainer = (CharacteristicTypeContainer)rs.getResource(createRelativeURI("models/travelPlanner/characteristicTypes.xmi"), true).getContents().get(0);
		EcoreUtil.resolveAll(rs);
		
		edu.kit.ipd.sdq.dataflow.systemmodel.System dataFlowSystemModel = subject.transform(usageModel, system, allocationModel, characteristicTypeContainer);
		Resource r = rs.createResource(createRelativeURI("models/travelPlanner/result.xmi"));
		r.getContents().add(dataFlowSystemModel);
		r.save(Collections.emptyMap());
	}
	
	@Test
	public void testMinimalEcho() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		UsageModel usageModel = (UsageModel)rs.getResource(createRelativeURI("models/minimalCallAndReturn/newUsageModel.usagemodel"), true).getContents().get(0);
		System system = (org.palladiosimulator.pcm.system.System)rs.getResource(createRelativeURI("models/minimalCallAndReturn/newSystem.system"), true).getContents().get(0);
		Allocation allocationModel = (Allocation)rs.getResource(createRelativeURI("models/minimalCallAndReturn/newAllocation.allocation"), true).getContents().get(0);
		CharacteristicTypeContainer characteristicTypeContainer = (CharacteristicTypeContainer)rs.getResource(createRelativeURI("models/minimalCallAndReturn/characteristicTypes.xmi"), true).getContents().get(0);
		EcoreUtil.resolveAll(rs);
		
		edu.kit.ipd.sdq.dataflow.systemmodel.System dataFlowSystemModel = subject.transform(usageModel, system, allocationModel, characteristicTypeContainer);
		Resource r = rs.createResource(createRelativeURI("models/minimalCallAndReturn/result.xmi"));
		r.getContents().add(dataFlowSystemModel);
		r.save(Collections.emptyMap());
	}
	
	protected static void registerProjectURI(Class<?> clz, String projectName) {
		File location = getProjectLocation(clz, projectName);
		URI projectURI = URI.createFileURI(location.getAbsolutePath()).appendSegment("");
		EcorePlugin.getPlatformResourceMap().put(projectName, projectURI);
	}
	
	protected static File getProjectLocation(Class<?> clz, String projectName) {
		String classLocation = clz.getProtectionDomain().getCodeSource().getLocation().getPath();
		String projectLocation = classLocation.substring(0, classLocation.indexOf(projectName) + projectName.length());
		return new File(projectLocation);
	}
	
	protected static URI createRelativeURI(String relativePath) {
		if (PLUGIN_TEST) {
			return URI.createFileURI(new File(relativePath).getAbsolutePath());
		}
		return createProjectRelativeURI("org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests", relativePath);
	}
	
	protected static URI createProjectRelativeURI(String projectName, String relativePath) {
		String uriString = String.format("/%s/%s", projectName, relativePath);
		return URI.createPlatformResourceURI(uriString, false);
	}
	
}
