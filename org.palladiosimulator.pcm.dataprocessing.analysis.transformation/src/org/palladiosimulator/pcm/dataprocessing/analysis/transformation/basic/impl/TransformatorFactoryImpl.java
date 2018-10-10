package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.impl;

import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.ITransformator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.ITransformatorFactory;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics.impl.IReturnValueAssignmentGeneratorRegistry;

@Component
public class TransformatorFactoryImpl implements ITransformatorFactory {

	@Reference
	private IReturnValueAssignmentGeneratorRegistry registry;
	
	@Override
	public ITransformator create(final IReturnValueAssignmentGeneratorRegistry registry) {
		IReturnValueAssignmentGeneratorRegistry registryToUse = Optional.ofNullable(registry).orElse(this.registry);
		return new PCM2DFSystemModelTransformation(registryToUse);
	}

}
