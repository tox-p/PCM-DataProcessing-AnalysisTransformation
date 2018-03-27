package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator;

import org.eclipse.emf.ecore.resource.Resource;

public interface IEcore2TxtGenerator {

	String generateContentsFromResource(Resource inputResource);
	
}
