package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic;

import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.Activator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.impl.IReturnValueAssignmentGeneratorRegistry;

public interface ITransformatorFactory {

	default ITransformator create() {
		return create(null);
	}
	
	ITransformator create(IReturnValueAssignmentGeneratorRegistry registry);
	
	static ITransformatorFactory getInstance() {
		return Activator.getInstance().getTransformatorFactoryInstance();
	}
}
