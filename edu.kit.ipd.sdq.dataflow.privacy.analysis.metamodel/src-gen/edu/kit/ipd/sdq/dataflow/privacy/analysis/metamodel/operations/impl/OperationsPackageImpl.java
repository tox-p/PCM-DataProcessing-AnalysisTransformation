/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.MetamodelPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.FlowPackageImpl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperationExecution;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.Operation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationCatalogue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecutingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecution;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsFactory;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
public class OperationsPackageImpl extends EPackageImpl implements OperationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationExecutingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCatalogueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCharacteristicChangingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTransformingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterizedDataTransformingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationExecutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCharacteristicChangingOperationExecutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTransformingOperationExecutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterizedDataTransformingOperationExecutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enumChangeOperationsEEnum = null;

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
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OperationsPackageImpl() {
		super(eNS_URI, OperationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OperationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OperationsPackage init() {
		if (isInited)
			return (OperationsPackage) EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI);

		// Obtain or create and register package
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new OperationsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(MetamodelPackage.eNS_URI) instanceof MetamodelPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI)
						: MetamodelPackage.eINSTANCE);
		CharacteristicsPackageImpl theCharacteristicsPackage = (CharacteristicsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(CharacteristicsPackage.eNS_URI) instanceof CharacteristicsPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(CharacteristicsPackage.eNS_URI)
						: CharacteristicsPackage.eINSTANCE);
		FlowPackageImpl theFlowPackage = (FlowPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(FlowPackage.eNS_URI) instanceof FlowPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI)
						: FlowPackage.eINSTANCE);

		// Create package meta-data objects
		theOperationsPackage.createPackageContents();
		theMetamodelPackage.createPackageContents();
		theCharacteristicsPackage.createPackageContents();
		theFlowPackage.createPackageContents();

		// Initialize created meta-data
		theOperationsPackage.initializePackageContents();
		theMetamodelPackage.initializePackageContents();
		theCharacteristicsPackage.initializePackageContents();
		theFlowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOperationsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI, theOperationsPackage);
		return theOperationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationExecutingElement() {
		return operationExecutingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationExecutingElement_OperationExecution() {
		return (EReference) operationExecutingElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCatalogue() {
		return operationCatalogueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCatalogue_Operations() {
		return (EReference) operationCatalogueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCharacteristicChangingOperation() {
		return enumCharacteristicChangingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumCharacteristicChangingOperation_Change() {
		return (EAttribute) enumCharacteristicChangingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTransformingOperation() {
		return dataTransformingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterizedDataTransformingOperation() {
		return parameterizedDataTransformingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationExecution() {
		return operationExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationExecution_Operation() {
		return (EReference) operationExecutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCharacteristicChangingOperationExecution() {
		return enumCharacteristicChangingOperationExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCharacteristicChangingOperationExecution_Enumcharacteristicvalue() {
		return (EReference) enumCharacteristicChangingOperationExecutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTransformingOperationExecution() {
		return dataTransformingOperationExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTransformingOperationExecution_Input() {
		return (EReference) dataTransformingOperationExecutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTransformingOperationExecution_Output() {
		return (EReference) dataTransformingOperationExecutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterizedDataTransformingOperationExecution() {
		return parameterizedDataTransformingOperationExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterizedDataTransformingOperationExecution_Parameter() {
		return (EReference) parameterizedDataTransformingOperationExecutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnumChangeOperations() {
		return enumChangeOperationsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactory getOperationsFactory() {
		return (OperationsFactory) getEFactoryInstance();
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
		operationExecutingElementEClass = createEClass(OPERATION_EXECUTING_ELEMENT);
		createEReference(operationExecutingElementEClass, OPERATION_EXECUTING_ELEMENT__OPERATION_EXECUTION);

		operationCatalogueEClass = createEClass(OPERATION_CATALOGUE);
		createEReference(operationCatalogueEClass, OPERATION_CATALOGUE__OPERATIONS);

		operationEClass = createEClass(OPERATION);

		enumCharacteristicChangingOperationEClass = createEClass(ENUM_CHARACTERISTIC_CHANGING_OPERATION);
		createEAttribute(enumCharacteristicChangingOperationEClass, ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE);

		dataTransformingOperationEClass = createEClass(DATA_TRANSFORMING_OPERATION);

		parameterizedDataTransformingOperationEClass = createEClass(PARAMETERIZED_DATA_TRANSFORMING_OPERATION);

		operationExecutionEClass = createEClass(OPERATION_EXECUTION);
		createEReference(operationExecutionEClass, OPERATION_EXECUTION__OPERATION);

		enumCharacteristicChangingOperationExecutionEClass = createEClass(
				ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION);
		createEReference(enumCharacteristicChangingOperationExecutionEClass,
				ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE);

		dataTransformingOperationExecutionEClass = createEClass(DATA_TRANSFORMING_OPERATION_EXECUTION);
		createEReference(dataTransformingOperationExecutionEClass, DATA_TRANSFORMING_OPERATION_EXECUTION__INPUT);
		createEReference(dataTransformingOperationExecutionEClass, DATA_TRANSFORMING_OPERATION_EXECUTION__OUTPUT);

		parameterizedDataTransformingOperationExecutionEClass = createEClass(
				PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION);
		createEReference(parameterizedDataTransformingOperationExecutionEClass,
				PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER);

		// Create enums
		enumChangeOperationsEEnum = createEEnum(ENUM_CHANGE_OPERATIONS);
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
		CharacteristicsPackage theCharacteristicsPackage = (CharacteristicsPackage) EPackage.Registry.INSTANCE
				.getEPackage(CharacteristicsPackage.eNS_URI);
		FlowPackage theFlowPackage = (FlowPackage) EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);

		// Create type parameters
		ETypeParameter operationExecutionEClass_T = addETypeParameter(operationExecutionEClass, "T");
		ETypeParameter dataTransformingOperationExecutionEClass_T = addETypeParameter(
				dataTransformingOperationExecutionEClass, "T");
		ETypeParameter parameterizedDataTransformingOperationExecutionEClass_T = addETypeParameter(
				parameterizedDataTransformingOperationExecutionEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getOperation());
		operationExecutionEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getDataTransformingOperation());
		dataTransformingOperationExecutionEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getParameterizedDataTransformingOperation());
		parameterizedDataTransformingOperationExecutionEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		operationEClass.getESuperTypes().add(theMetamodelPackage.getEntity());
		enumCharacteristicChangingOperationEClass.getESuperTypes().add(this.getOperation());
		dataTransformingOperationEClass.getESuperTypes().add(this.getOperation());
		parameterizedDataTransformingOperationEClass.getESuperTypes().add(this.getDataTransformingOperation());
		g1 = createEGenericType(this.getOperationExecution());
		EGenericType g2 = createEGenericType(this.getEnumCharacteristicChangingOperation());
		g1.getETypeArguments().add(g2);
		enumCharacteristicChangingOperationExecutionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOperationExecution());
		g2 = createEGenericType(dataTransformingOperationExecutionEClass_T);
		g1.getETypeArguments().add(g2);
		dataTransformingOperationExecutionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDataTransformingOperationExecution());
		g2 = createEGenericType(parameterizedDataTransformingOperationExecutionEClass_T);
		g1.getETypeArguments().add(g2);
		parameterizedDataTransformingOperationExecutionEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(operationExecutingElementEClass, OperationExecutingElement.class, "OperationExecutingElement",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getOperationExecution());
		g2 = createEGenericType(this.getOperation());
		g1.getETypeArguments().add(g2);
		initEReference(getOperationExecutingElement_OperationExecution(), g1, null, "operationExecution", null, 0, 1,
				OperationExecutingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationCatalogueEClass, OperationCatalogue.class, "OperationCatalogue", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCatalogue_Operations(), this.getOperation(), null, "operations", null, 0, -1,
				OperationCatalogue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumCharacteristicChangingOperationEClass, EnumCharacteristicChangingOperation.class,
				"EnumCharacteristicChangingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumCharacteristicChangingOperation_Change(), this.getEnumChangeOperations(), "change", null,
				0, 1, EnumCharacteristicChangingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTransformingOperationEClass, DataTransformingOperation.class, "DataTransformingOperation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterizedDataTransformingOperationEClass, ParameterizedDataTransformingOperation.class,
				"ParameterizedDataTransformingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationExecutionEClass, OperationExecution.class, "OperationExecution", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(operationExecutionEClass_T);
		initEReference(getOperationExecution_Operation(), g1, null, "operation", null, 1, 1, OperationExecution.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumCharacteristicChangingOperationExecutionEClass,
				EnumCharacteristicChangingOperationExecution.class, "EnumCharacteristicChangingOperationExecution",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumCharacteristicChangingOperationExecution_Enumcharacteristicvalue(),
				theCharacteristicsPackage.getEnumCharacteristicValue(), null, "enumcharacteristicvalue", null, 1, 1,
				EnumCharacteristicChangingOperationExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTransformingOperationExecutionEClass, DataTransformingOperationExecution.class,
				"DataTransformingOperationExecution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataTransformingOperationExecution_Input(), theFlowPackage.getData(), null, "input", null, 1,
				1, DataTransformingOperationExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataTransformingOperationExecution_Output(), theFlowPackage.getData(), null, "output", null,
				1, 1, DataTransformingOperationExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterizedDataTransformingOperationExecutionEClass,
				ParameterizedDataTransformingOperationExecution.class,
				"ParameterizedDataTransformingOperationExecution", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterizedDataTransformingOperationExecution_Parameter(), theFlowPackage.getData(), null,
				"parameter", null, 1, 1, ParameterizedDataTransformingOperationExecution.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(enumChangeOperationsEEnum, EnumChangeOperations.class, "EnumChangeOperations");
		addEEnumLiteral(enumChangeOperationsEEnum, EnumChangeOperations.ADD);
		addEEnumLiteral(enumChangeOperationsEEnum, EnumChangeOperations.REMOVE);
	}

} //OperationsPackageImpl
