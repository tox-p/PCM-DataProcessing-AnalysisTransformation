package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.characteristics;

import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.Characteristic;

import edu.kit.ipd.sdq.dataflow.systemmodel.Value;
import edu.kit.ipd.sdq.dataflow.systemmodel.Attribute;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicType;

public interface IQueryExecutor {

	Iterable<Value> getValues(Characteristic characteristic);

	abstract Attribute getAttribute(CharacteristicType type);

	Iterable<Value> getValues(CharacteristicType characteristicType);
	
	Iterable<CharacteristicType> getCharacteristicTypes();
}
