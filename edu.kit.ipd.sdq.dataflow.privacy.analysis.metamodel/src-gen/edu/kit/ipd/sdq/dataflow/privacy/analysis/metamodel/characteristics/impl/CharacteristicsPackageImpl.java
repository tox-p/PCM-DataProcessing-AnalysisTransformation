/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.MetamodelPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsFactory;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiterals;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.FlowPackageImpl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CharacteristicsPackageImpl extends EPackageImpl implements CharacteristicsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicsHavingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicCatalogueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCharacteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCharacteristicValueEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CharacteristicsPackageImpl() {
		super(eNS_URI, CharacteristicsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CharacteristicsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CharacteristicsPackage init() {
		if (isInited)
			return (CharacteristicsPackage) EPackage.Registry.INSTANCE.getEPackage(CharacteristicsPackage.eNS_URI);

		// Obtain or create and register package
		CharacteristicsPackageImpl theCharacteristicsPackage = (CharacteristicsPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof CharacteristicsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new CharacteristicsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(MetamodelPackage.eNS_URI) instanceof MetamodelPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI)
						: MetamodelPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI)
						: OperationsPackage.eINSTANCE);
		FlowPackageImpl theFlowPackage = (FlowPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(FlowPackage.eNS_URI) instanceof FlowPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI)
						: FlowPackage.eINSTANCE);

		// Create package meta-data objects
		theCharacteristicsPackage.createPackageContents();
		theMetamodelPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theFlowPackage.createPackageContents();

		// Initialize created meta-data
		theCharacteristicsPackage.initializePackageContents();
		theMetamodelPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theFlowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCharacteristicsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CharacteristicsPackage.eNS_URI, theCharacteristicsPackage);
		return theCharacteristicsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristicsHavingElement() {
		return characteristicsHavingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacteristicsHavingElement_Characteristic() {
		return (EReference) characteristicsHavingElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristicCatalogue() {
		return characteristicCatalogueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacteristicCatalogue_Characteristics() {
		return (EReference) characteristicCatalogueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristic() {
		return characteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCharacteristic() {
		return enumCharacteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCharacteristic_Enumliterals() {
		return (EReference) enumCharacteristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiterals() {
		return enumLiteralsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristicValue() {
		return characteristicValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacteristicValue_Characteristic() {
		return (EReference) characteristicValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCharacteristicValue() {
		return enumCharacteristicValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCharacteristicValue_Enumliterals() {
		return (EReference) enumCharacteristicValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicsFactory getCharacteristicsFactory() {
		return (CharacteristicsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		characteristicsHavingElementEClass = createEClass(CHARACTERISTICS_HAVING_ELEMENT);
		createEReference(characteristicsHavingElementEClass, CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC);

		characteristicCatalogueEClass = createEClass(CHARACTERISTIC_CATALOGUE);
		createEReference(characteristicCatalogueEClass, CHARACTERISTIC_CATALOGUE__CHARACTERISTICS);

		characteristicEClass = createEClass(CHARACTERISTIC);

		enumCharacteristicEClass = createEClass(ENUM_CHARACTERISTIC);
		createEReference(enumCharacteristicEClass, ENUM_CHARACTERISTIC__ENUMLITERALS);

		enumLiteralsEClass = createEClass(ENUM_LITERALS);

		characteristicValueEClass = createEClass(CHARACTERISTIC_VALUE);
		createEReference(characteristicValueEClass, CHARACTERISTIC_VALUE__CHARACTERISTIC);

		enumCharacteristicValueEClass = createEClass(ENUM_CHARACTERISTIC_VALUE);
		createEReference(enumCharacteristicValueEClass, ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(MetamodelPackage.eNS_URI);

		// Create type parameters
		ETypeParameter characteristicValueEClass_T = addETypeParameter(characteristicValueEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getCharacteristic());
		characteristicValueEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		characteristicEClass.getESuperTypes().add(theMetamodelPackage.getEntity());
		enumCharacteristicEClass.getESuperTypes().add(this.getCharacteristic());
		enumLiteralsEClass.getESuperTypes().add(theMetamodelPackage.getEntity());
		g1 = createEGenericType(this.getCharacteristicValue());
		EGenericType g2 = createEGenericType(this.getEnumCharacteristic());
		g1.getETypeArguments().add(g2);
		enumCharacteristicValueEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(characteristicsHavingElementEClass, CharacteristicsHavingElement.class,
				"CharacteristicsHavingElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getCharacteristicValue());
		g2 = createEGenericType(this.getCharacteristic());
		g1.getETypeArguments().add(g2);
		initEReference(getCharacteristicsHavingElement_Characteristic(), g1, null, "characteristic", null, 0, -1,
				CharacteristicsHavingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characteristicCatalogueEClass, CharacteristicCatalogue.class, "CharacteristicCatalogue",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacteristicCatalogue_Characteristics(), this.getCharacteristic(), null, "characteristics",
				null, 0, -1, CharacteristicCatalogue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characteristicEClass, Characteristic.class, "Characteristic", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumCharacteristicEClass, EnumCharacteristic.class, "EnumCharacteristic", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumCharacteristic_Enumliterals(), this.getEnumLiterals(), null, "enumliterals", null, 0, -1,
				EnumCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralsEClass, EnumLiterals.class, "EnumLiterals", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(characteristicValueEClass, CharacteristicValue.class, "CharacteristicValue", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(characteristicValueEClass_T);
		initEReference(getCharacteristicValue_Characteristic(), g1, null, "characteristic", null, 1, 1,
				CharacteristicValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumCharacteristicValueEClass, EnumCharacteristicValue.class, "EnumCharacteristicValue",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumCharacteristicValue_Enumliterals(), this.getEnumLiterals(), null, "enumliterals", null, 0,
				-1, EnumCharacteristicValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CharacteristicsPackageImpl
