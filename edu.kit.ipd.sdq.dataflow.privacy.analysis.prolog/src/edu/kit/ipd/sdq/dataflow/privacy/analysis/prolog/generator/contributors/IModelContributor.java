package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;

public interface IModelContributor {

	default Iterable<URI> getOperationModels() {
		return Optional.ofNullable(getOperationModel()).map(Arrays::asList).orElse(Collections.emptyList());
	}
	
	default URI getOperationModel() {
		return null;
	}

	default Iterable<URI> getCharacteristicModels() {
		return Optional.ofNullable(getCharacteristicModel()).map(Arrays::asList).orElse(Collections.emptyList());
	}
	
	default URI getCharacteristicModel() {
		return null;
	}

}
