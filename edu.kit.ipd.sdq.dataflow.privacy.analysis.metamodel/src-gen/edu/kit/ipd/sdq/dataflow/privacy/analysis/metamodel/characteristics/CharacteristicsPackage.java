/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.MetamodelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsFactory
 * @model kind="package"
 * @generated
 */
public interface CharacteristicsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "characteristics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.kit.edu/dataflow/privacy/analysis/mm/characteristics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "characteristics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CharacteristicsPackage eINSTANCE = edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsHavingElementImpl <em>Having Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsHavingElementImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristicsHavingElement()
	 * @generated
	 */
	int CHARACTERISTICS_HAVING_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC = 0;

	/**
	 * The number of structural features of the '<em>Having Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTICS_HAVING_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Having Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTICS_HAVING_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicCatalogueImpl <em>Characteristic Catalogue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicCatalogueImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristicCatalogue()
	 * @generated
	 */
	int CHARACTERISTIC_CATALOGUE = 1;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_CATALOGUE__CHARACTERISTICS = 0;

	/**
	 * The number of structural features of the '<em>Characteristic Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_CATALOGUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Characteristic Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_CATALOGUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicImpl <em>Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristic()
	 * @generated
	 */
	int CHARACTERISTIC = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__ID = MetamodelPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__NAME = MetamodelPackage.ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_FEATURE_COUNT = MetamodelPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_OPERATION_COUNT = MetamodelPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicImpl <em>Enum Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getEnumCharacteristic()
	 * @generated
	 */
	int ENUM_CHARACTERISTIC = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__ID = CHARACTERISTIC__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__NAME = CHARACTERISTIC__NAME;

	/**
	 * The feature id for the '<em><b>Enumliterals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__ENUMLITERALS = CHARACTERISTIC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_FEATURE_COUNT = CHARACTERISTIC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_OPERATION_COUNT = CHARACTERISTIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumLiteralsImpl <em>Enum Literals</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumLiteralsImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getEnumLiterals()
	 * @generated
	 */
	int ENUM_LITERALS = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERALS__ID = MetamodelPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERALS__NAME = MetamodelPackage.ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Enum Literals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERALS_FEATURE_COUNT = MetamodelPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Enum Literals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERALS_OPERATION_COUNT = MetamodelPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicValueImpl <em>Characteristic Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicValueImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristicValue()
	 * @generated
	 */
	int CHARACTERISTIC_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_VALUE__CHARACTERISTIC = 0;

	/**
	 * The number of structural features of the '<em>Characteristic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Characteristic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicValueImpl <em>Enum Characteristic Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicValueImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getEnumCharacteristicValue()
	 * @generated
	 */
	int ENUM_CHARACTERISTIC_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_VALUE__CHARACTERISTIC = CHARACTERISTIC_VALUE__CHARACTERISTIC;

	/**
	 * The feature id for the '<em><b>Enumliterals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS = CHARACTERISTIC_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Characteristic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_VALUE_FEATURE_COUNT = CHARACTERISTIC_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Characteristic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_VALUE_OPERATION_COUNT = CHARACTERISTIC_VALUE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement <em>Having Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Having Element</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement
	 * @generated
	 */
	EClass getCharacteristicsHavingElement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement#getCharacteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Characteristic</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement#getCharacteristic()
	 * @see #getCharacteristicsHavingElement()
	 * @generated
	 */
	EReference getCharacteristicsHavingElement_Characteristic();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue <em>Characteristic Catalogue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic Catalogue</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue
	 * @generated
	 */
	EClass getCharacteristicCatalogue();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue#getCharacteristics <em>Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Characteristics</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue#getCharacteristics()
	 * @see #getCharacteristicCatalogue()
	 * @generated
	 */
	EReference getCharacteristicCatalogue_Characteristics();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic
	 * @generated
	 */
	EClass getCharacteristic();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic <em>Enum Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Characteristic</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic
	 * @generated
	 */
	EClass getEnumCharacteristic();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic#getEnumliterals <em>Enumliterals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enumliterals</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic#getEnumliterals()
	 * @see #getEnumCharacteristic()
	 * @generated
	 */
	EReference getEnumCharacteristic_Enumliterals();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiterals <em>Enum Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literals</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiterals
	 * @generated
	 */
	EClass getEnumLiterals();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue <em>Characteristic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic Value</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue
	 * @generated
	 */
	EClass getCharacteristicValue();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue#getCharacteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Characteristic</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue#getCharacteristic()
	 * @see #getCharacteristicValue()
	 * @generated
	 */
	EReference getCharacteristicValue_Characteristic();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue <em>Enum Characteristic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Characteristic Value</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue
	 * @generated
	 */
	EClass getEnumCharacteristicValue();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue#getEnumliterals <em>Enumliterals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enumliterals</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue#getEnumliterals()
	 * @see #getEnumCharacteristicValue()
	 * @generated
	 */
	EReference getEnumCharacteristicValue_Enumliterals();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CharacteristicsFactory getCharacteristicsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsHavingElementImpl <em>Having Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsHavingElementImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristicsHavingElement()
		 * @generated
		 */
		EClass CHARACTERISTICS_HAVING_ELEMENT = eINSTANCE.getCharacteristicsHavingElement();

		/**
		 * The meta object literal for the '<em><b>Characteristic</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC = eINSTANCE
				.getCharacteristicsHavingElement_Characteristic();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicCatalogueImpl <em>Characteristic Catalogue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicCatalogueImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristicCatalogue()
		 * @generated
		 */
		EClass CHARACTERISTIC_CATALOGUE = eINSTANCE.getCharacteristicCatalogue();

		/**
		 * The meta object literal for the '<em><b>Characteristics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISTIC_CATALOGUE__CHARACTERISTICS = eINSTANCE.getCharacteristicCatalogue_Characteristics();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicImpl <em>Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristic()
		 * @generated
		 */
		EClass CHARACTERISTIC = eINSTANCE.getCharacteristic();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicImpl <em>Enum Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getEnumCharacteristic()
		 * @generated
		 */
		EClass ENUM_CHARACTERISTIC = eINSTANCE.getEnumCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Enumliterals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CHARACTERISTIC__ENUMLITERALS = eINSTANCE.getEnumCharacteristic_Enumliterals();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumLiteralsImpl <em>Enum Literals</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumLiteralsImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getEnumLiterals()
		 * @generated
		 */
		EClass ENUM_LITERALS = eINSTANCE.getEnumLiterals();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicValueImpl <em>Characteristic Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicValueImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getCharacteristicValue()
		 * @generated
		 */
		EClass CHARACTERISTIC_VALUE = eINSTANCE.getCharacteristicValue();

		/**
		 * The meta object literal for the '<em><b>Characteristic</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISTIC_VALUE__CHARACTERISTIC = eINSTANCE.getCharacteristicValue_Characteristic();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicValueImpl <em>Enum Characteristic Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicValueImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl#getEnumCharacteristicValue()
		 * @generated
		 */
		EClass ENUM_CHARACTERISTIC_VALUE = eINSTANCE.getEnumCharacteristicValue();

		/**
		 * The meta object literal for the '<em><b>Enumliterals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS = eINSTANCE.getEnumCharacteristicValue_Enumliterals();

	}

} //CharacteristicsPackage
