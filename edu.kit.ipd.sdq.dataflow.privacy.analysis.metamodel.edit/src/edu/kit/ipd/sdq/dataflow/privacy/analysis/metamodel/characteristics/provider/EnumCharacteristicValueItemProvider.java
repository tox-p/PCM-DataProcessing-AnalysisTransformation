/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.provider;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiterals;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.util.ItemPropertyDescriptorWrapper;

public class EnumCharacteristicValueItemProvider extends edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.provider.orig.EnumCharacteristicValueItemProvider {

	public EnumCharacteristicValueItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void addEnumliteralsPropertyDescriptor(Object object) {
		ItemPropertyDescriptor originalDescriptor = createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_EnumCharacteristicValue_enumliterals_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_EnumCharacteristicValue_enumliterals_feature", "_UI_EnumCharacteristicValue_type"),
				CharacteristicsPackage.Literals.ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS, true, false, true,
				null, null, null);
		IItemPropertyDescriptor descriptor = new ItemPropertyDescriptorWrapper(originalDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> values = super.getChoiceOfValues(thisObject);
				Optional<EnumCharacteristic> characteristic = Optional.ofNullable(thisObject)
						.filter(EnumCharacteristicValue.class::isInstance).map(EnumCharacteristicValue.class::cast)
						.map(EnumCharacteristicValue::getCharacteristic);
				return values.stream().filter(EnumLiterals.class::isInstance).map(EnumLiterals.class::cast)
						.filter(l -> characteristic.map(l.eContainer()::equals).orElse(false))
						.collect(Collectors.toList());
			}
			
		};
		itemPropertyDescriptors
				.add(descriptor);
	}

}
