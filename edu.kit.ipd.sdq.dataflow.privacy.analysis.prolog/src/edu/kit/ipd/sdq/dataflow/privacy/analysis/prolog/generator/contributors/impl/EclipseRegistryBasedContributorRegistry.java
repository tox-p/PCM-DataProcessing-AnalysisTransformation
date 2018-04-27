package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.IPrologGeneratorContributorRegistry;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.IPrologGeneratorContributor;

public class EclipseRegistryBasedContributorRegistry implements IPrologGeneratorContributorRegistry {

	private static final String EP_ID = "edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributor";
	private final Iterable<IPrologGeneratorContributor> contributors;
	
	public EclipseRegistryBasedContributorRegistry() {
		contributors = createContributors();
	}
	
	protected Iterable<IPrologGeneratorContributor> createContributors() {
		Collection<IPrologGeneratorContributor> contributors = new ArrayList<>();
		
	    IExtensionRegistry reg = Platform.getExtensionRegistry();
	    IConfigurationElement[] elements = reg.getConfigurationElementsFor(EP_ID);
	    for (IConfigurationElement element : elements) {
	    	try {
				contributors.add((IPrologGeneratorContributor)element.createExecutableExtension("class"));
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

		return Collections.unmodifiableCollection(contributors);
	}

	@Override
	public Iterable<IPrologGeneratorContributor> getContributors() {
		return contributors;
	}
	
}
