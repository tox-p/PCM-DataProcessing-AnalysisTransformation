package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic;

import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer;
import org.palladiosimulator.pcm.usagemodel.UsageModel;

public interface ITransformator {
	
	edu.kit.ipd.sdq.dataflow.systemmodel.System transform(UsageModel pcmUsageModel, org.palladiosimulator.pcm.system.System pcmSystem,
			Allocation pcmAllocationModel, CharacteristicTypeContainer pcmCharacteristicTypeContainer);
	
}
