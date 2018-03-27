package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.IPrologGeneratorContributor;

public interface IPrologGeneratorContributorRegistry {

	Iterable<IPrologGeneratorContributor> getContributors();
	
}
