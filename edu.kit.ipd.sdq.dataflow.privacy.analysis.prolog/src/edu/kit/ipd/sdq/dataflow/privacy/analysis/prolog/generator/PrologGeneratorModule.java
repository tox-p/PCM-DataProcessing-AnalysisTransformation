package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.impl.EclipseRegistryBasedContributorRegistry;
import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGeneratorModule;

public class PrologGeneratorModule extends AbstractEcore2TxtGeneratorModule {

	public Class<? extends IEcore2TxtGenerator> bindIEcore2TxtGenerator() {
		return PrologGenerator.class;
	}
	
	public Class<? extends IPrologGeneratorContributorRegistry> bindIPrologGeneratorContributorRegistry() {
		return EclipseRegistryBasedContributorRegistry.class;
	}
	
	@Override
	protected String getLanguageName() {
		return "Privacy Prolog";
	}

	@Override
	protected String getFileExtensions() {
		return "dflow";
	}

}
