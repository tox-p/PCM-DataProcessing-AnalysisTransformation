package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.DataFlowDiagram;

public interface IPrologGeneratorContributor {

	default String getIdentifier() {
		return getClass().getName();
	}
	
	default String getFacts(DataFlowDiagram diagram) {
		return "";
	}
	
	default String getRules(DataFlowDiagram diagram) {
		return "";
	}
	
}
