package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.impl;

import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.IReturnValueAssignmentGenerator;

public interface IReturnValueAssignmentGeneratorRegistry {

	/**
	 * 
	 * @return Generators starting from lowest to highest priority.
	 */
	Iterable<IReturnValueAssignmentGenerator> getGenerators();

}