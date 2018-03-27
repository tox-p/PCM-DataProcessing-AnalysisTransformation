/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CharacteristicsFactoryImpl extends EFactoryImpl implements CharacteristicsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CharacteristicsFactory init() {
		try {
			CharacteristicsFactory theCharacteristicsFactory = (CharacteristicsFactory) EPackage.Registry.INSTANCE
					.getEFactory(CharacteristicsPackage.eNS_URI);
			if (theCharacteristicsFactory != null) {
				return theCharacteristicsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CharacteristicsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT:
			return createCharacteristicsHavingElement();
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE:
			return createCharacteristicCatalogue();
		case CharacteristicsPackage.ENUM_CHARACTERISTIC:
			return createEnumCharacteristic();
		case CharacteristicsPackage.ENUM_LITERALS:
			return createEnumLiterals();
		case CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE:
			return createEnumCharacteristicValue();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicsHavingElement createCharacteristicsHavingElement() {
		CharacteristicsHavingElementImpl characteristicsHavingElement = new CharacteristicsHavingElementImpl();
		return characteristicsHavingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicCatalogue createCharacteristicCatalogue() {
		CharacteristicCatalogueImpl characteristicCatalogue = new CharacteristicCatalogueImpl();
		return characteristicCatalogue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristic createEnumCharacteristic() {
		EnumCharacteristicImpl enumCharacteristic = new EnumCharacteristicImpl();
		return enumCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiterals createEnumLiterals() {
		EnumLiteralsImpl enumLiterals = new EnumLiteralsImpl();
		return enumLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristicValue createEnumCharacteristicValue() {
		EnumCharacteristicValueImpl enumCharacteristicValue = new EnumCharacteristicValueImpl();
		return enumCharacteristicValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicsPackage getCharacteristicsPackage() {
		return (CharacteristicsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CharacteristicsPackage getPackage() {
		return CharacteristicsPackage.eINSTANCE;
	}

} //CharacteristicsFactoryImpl
