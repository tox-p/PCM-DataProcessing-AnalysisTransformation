package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.tests.accesscontrol;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.inject.Guice;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.MetamodelPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccesscontrolPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.contribution.AccessControlContributor;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.IEcore2TxtGenerator;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.IPrologGeneratorContributorRegistry;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.PrologGeneratorModule;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.IPrologGeneratorContributor;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.impl.EclipseRegistryBasedContributorRegistry;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational.contribution.RelationalContributor;

public class PrologGeneratorStandalone {

	protected static class Registry extends EclipseRegistryBasedContributorRegistry {

		@Override
		protected Iterable<IPrologGeneratorContributor> createContributors() {
			return Arrays.asList(new ContributorWrapper(new AccessControlContributor()),
					new ContributorWrapper(new RelationalContributor()));
		}

	}

	protected static class Module extends PrologGeneratorModule {

		@Override
		public Class<? extends IPrologGeneratorContributorRegistry> bindIPrologGeneratorContributorRegistry() {
			return Registry.class;
		}

	}

	public PrologGeneratorStandalone() throws URISyntaxException {
		initPlatformResourceMap();
		initResourceFactories();
		initEPackages();
	}

	protected void initEPackages() {
		MetamodelPackage.eINSTANCE.eClass();
		FlowPackage.eINSTANCE.eClass();
		CharacteristicsPackage.eINSTANCE.eClass();
		OperationsPackage.eINSTANCE.eClass();
		AccesscontrolPackage.eINSTANCE.eClass();
	}

	protected void initResourceFactories() {
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> map = registry.getExtensionToFactoryMap();
		map.put("*", new XMIResourceFactoryImpl());
	}

	protected void initPlatformResourceMap() throws URISyntaxException {
		EcorePlugin.getPlatformResourceMap().putIfAbsent(
				"edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol",
				determinePluginUri("edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol",
						AccessControlContributor.class));
		EcorePlugin.getPlatformResourceMap().putIfAbsent("edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational",
				determinePluginUri("edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational",
						RelationalContributor.class));
		URIConverter.URI_MAP.put(URI.createPlatformPluginURI(
				"/edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol/model/OperationCatalogue.xmi", false),
				URI.createPlatformResourceURI(
						"/edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol/model/OperationCatalogue.xmi",
						false));
		URIConverter.URI_MAP.put(URI.createPlatformPluginURI(
				"/edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational/model/OperationCatalogue.xmi", false),
				URI.createPlatformResourceURI(
						"/edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational/model/OperationCatalogue.xmi",
						false));
	}

	public IEcore2TxtGenerator getGenerator() {
		Module module = new Module();
		return Guice.createInjector(module).getInstance(IEcore2TxtGenerator.class);
	}

	protected static URI determinePluginUri(String pluginId, Class<?> classOfPlugin) throws URISyntaxException {
		Path p = Paths.get(classOfPlugin.getProtectionDomain().getCodeSource().getLocation().toURI());
		while (p.getParent() != null && !p.getFileName().toString().equals(pluginId)) {
			p = p.getParent();
		}
		return URI.createFileURI(p.toAbsolutePath().toFile().toString() + "/");
	}

}
