package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests

import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.modelversioning.emfprofile.Profile
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.graph.DataOperationGraphFactory
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.DataSpecification
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ProcessingFactory
import org.palladiosimulator.pcm.dataprocessing.profile.api.Api

import static org.junit.Assert.*

class DataOperationGraphFactoryTest {
	
	static val PLUGIN_TEST = EcorePlugin.IS_ECLIPSE_RUNNING;
	static val OP_FACTORY = ProcessingFactory.eINSTANCE
	static val DUMMY_OPERATION = OP_FACTORY.createReturnDataOperation
	
	DataOperationGraphFactory subject
	
	@BeforeClass
	static def void init() {
		if (!PLUGIN_TEST) {
			initStandalone();
		}
	}
	
	protected static def initStandalone() {
		// Detection of Meta Models and URIs by classpath magic
		// https://wiki.eclipse.org/EMF/FAQ#How_do_I_make_my_EMF_standalone_application_Eclipse-aware.3F
		EcorePlugin.ExtensionProcessor.process(null);

		// OCL Pivot
		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();

		// Resource URI Mapping
		registerProjectURI(Api, "org.palladiosimulator.pcm.dataprocessing.profile");
		registerProjectURI(TransformationTest, "org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests");
		
		// PCM Data Profile
		val rs = new ResourceSetImpl();
		val profileURI = createProjectRelativeURI("org.palladiosimulator.pcm.dataprocessing.profile", "profile.emfprofile_diagram");
		val profile = rs.getResource(profileURI, true).getContents().get(0) as Profile
		EPackageRegistryImpl.INSTANCE.put(profile.getNsURI(), profile);
	}
	
	protected static def registerProjectURI(Class<?> clz, String projectName) {
		val location = getProjectLocation(clz, projectName);
		val projectURI = URI.createFileURI(location.getAbsolutePath()).appendSegment("");
		EcorePlugin.getPlatformResourceMap().put(projectName, projectURI);
	}
	
	protected static def getProjectLocation(Class<?> clz, String projectName) {
		val classLocation = clz.getProtectionDomain().getCodeSource().getLocation().getPath();
		val projectLocation = classLocation.substring(0, classLocation.indexOf(projectName) + projectName.length());
		return new File(projectLocation);
	}
	
	protected static def createRelativeURI(String relativePath) {
		if (PLUGIN_TEST) {
			return URI.createFileURI(new File(relativePath).getAbsolutePath());
		}
		return createProjectRelativeURI("org.palladiosimulator.pcm.dataprocessing.analysis.transformation.tests", relativePath);
	}
	
	protected static def createProjectRelativeURI(String projectName, String relativePath) {
		val uriString = String.format("/%s/%s", projectName, relativePath);
		return URI.createPlatformResourceURI(uriString, false);
	}
	
	@Before
	def void setup() {
		subject = new DataOperationGraphFactory(DUMMY_OPERATION)
	}
	
	@Test
	def testSimple() {
		val rs = new ResourceSetImpl();
		val dataSpecification = rs.getResource(createRelativeURI("models/minimalCallAndReturn/DataSpecification.xmi"), true).getContents().get(0) as DataSpecification
		EcoreUtil.resolveAll(rs);
		val container = dataSpecification.dataProcessingContainers.findFirst[id == "seffReadWriteEchoData"]
		
		val actual = subject.createDataOpGraph(container.operations)
		assertEquals(2, actual.vertexSet.size)
		assertEquals(1, actual.edgeSet.size)
		assertEquals(1, actual.outgoingEdgesOf(DUMMY_OPERATION).size)
		assertEquals(0, actual.incomingEdgesOf(DUMMY_OPERATION).size)
		assertEquals(0, actual.outgoingEdgesOf(actual.vertexSet.findFirst[v | v !== DUMMY_OPERATION]).size)
	}
	
}