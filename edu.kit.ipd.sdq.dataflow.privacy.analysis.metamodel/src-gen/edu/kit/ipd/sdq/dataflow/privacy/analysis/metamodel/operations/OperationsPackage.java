/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.MetamodelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsFactory
 * @model kind="package"
 * @generated
 */
public interface OperationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.kit.edu/dataflow/privacy/analysis/mm/operations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "operations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsPackage eINSTANCE = edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutingElementImpl <em>Operation Executing Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutingElementImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperationExecutingElement()
	 * @generated
	 */
	int OPERATION_EXECUTING_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Operation Execution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_EXECUTING_ELEMENT__OPERATION_EXECUTION = 0;

	/**
	 * The number of structural features of the '<em>Operation Executing Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_EXECUTING_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Operation Executing Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_EXECUTING_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationCatalogueImpl <em>Operation Catalogue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationCatalogueImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperationCatalogue()
	 * @generated
	 */
	int OPERATION_CATALOGUE = 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CATALOGUE__OPERATIONS = 0;

	/**
	 * The number of structural features of the '<em>Operation Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CATALOGUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Operation Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CATALOGUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ID = MetamodelPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = MetamodelPackage.ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = MetamodelPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = MetamodelPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationImpl <em>Enum Characteristic Changing Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getEnumCharacteristicChangingOperation()
	 * @generated
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION__ID = OPERATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION__NAME = OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Characteristic Changing Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Characteristic Changing Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationImpl <em>Data Transforming Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getDataTransformingOperation()
	 * @generated
	 */
	int DATA_TRANSFORMING_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION__ID = OPERATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION__NAME = OPERATION__NAME;

	/**
	 * The number of structural features of the '<em>Data Transforming Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Transforming Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationImpl <em>Parameterized Data Transforming Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getParameterizedDataTransformingOperation()
	 * @generated
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION__ID = DATA_TRANSFORMING_OPERATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION__NAME = DATA_TRANSFORMING_OPERATION__NAME;

	/**
	 * The number of structural features of the '<em>Parameterized Data Transforming Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_FEATURE_COUNT = DATA_TRANSFORMING_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameterized Data Transforming Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_OPERATION_COUNT = DATA_TRANSFORMING_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutionImpl <em>Operation Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutionImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperationExecution()
	 * @generated
	 */
	int OPERATION_EXECUTION = 6;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_EXECUTION__OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_EXECUTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_EXECUTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataCharacteristicChangingOperationExecutionImpl <em>Data Characteristic Changing Operation Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataCharacteristicChangingOperationExecutionImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getDataCharacteristicChangingOperationExecution()
	 * @generated
	 */
	int DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION = 7;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__OPERATION = OPERATION_EXECUTION__OPERATION;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA = OPERATION_EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Characteristic Changing Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION_FEATURE_COUNT = OPERATION_EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Characteristic Changing Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION_OPERATION_COUNT = OPERATION_EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationExecutionImpl <em>Enum Characteristic Changing Operation Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationExecutionImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getEnumCharacteristicChangingOperationExecution()
	 * @generated
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION = 8;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__OPERATION = DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__OPERATION;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA = DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA;

	/**
	 * The feature id for the '<em><b>Enumcharacteristicvalue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE = DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION_FEATURE_COUNT
			+ 0;

	/**
	 * The number of structural features of the '<em>Enum Characteristic Changing Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION_FEATURE_COUNT = DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION_FEATURE_COUNT
			+ 1;

	/**
	 * The number of operations of the '<em>Enum Characteristic Changing Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION_OPERATION_COUNT = DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION_OPERATION_COUNT
			+ 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationExecutionImpl <em>Data Transforming Operation Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationExecutionImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getDataTransformingOperationExecution()
	 * @generated
	 */
	int DATA_TRANSFORMING_OPERATION_EXECUTION = 9;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION_EXECUTION__OPERATION = OPERATION_EXECUTION__OPERATION;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION_EXECUTION__INPUT = OPERATION_EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION_EXECUTION__OUTPUT = OPERATION_EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Transforming Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION_EXECUTION_FEATURE_COUNT = OPERATION_EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Transforming Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TRANSFORMING_OPERATION_EXECUTION_OPERATION_COUNT = OPERATION_EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationExecutionImpl <em>Parameterized Data Transforming Operation Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationExecutionImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getParameterizedDataTransformingOperationExecution()
	 * @generated
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION = 10;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__OPERATION = DATA_TRANSFORMING_OPERATION_EXECUTION__OPERATION;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__INPUT = DATA_TRANSFORMING_OPERATION_EXECUTION__INPUT;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__OUTPUT = DATA_TRANSFORMING_OPERATION_EXECUTION__OUTPUT;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER = DATA_TRANSFORMING_OPERATION_EXECUTION_FEATURE_COUNT
			+ 0;

	/**
	 * The number of structural features of the '<em>Parameterized Data Transforming Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION_FEATURE_COUNT = DATA_TRANSFORMING_OPERATION_EXECUTION_FEATURE_COUNT
			+ 1;

	/**
	 * The number of operations of the '<em>Parameterized Data Transforming Operation Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION_OPERATION_COUNT = DATA_TRANSFORMING_OPERATION_EXECUTION_OPERATION_COUNT
			+ 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations <em>Enum Change Operations</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getEnumChangeOperations()
	 * @generated
	 */
	int ENUM_CHANGE_OPERATIONS = 11;

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecutingElement <em>Operation Executing Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Executing Element</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecutingElement
	 * @generated
	 */
	EClass getOperationExecutingElement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecutingElement#getOperationExecution <em>Operation Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Execution</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecutingElement#getOperationExecution()
	 * @see #getOperationExecutingElement()
	 * @generated
	 */
	EReference getOperationExecutingElement_OperationExecution();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationCatalogue <em>Operation Catalogue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Catalogue</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationCatalogue
	 * @generated
	 */
	EClass getOperationCatalogue();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationCatalogue#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationCatalogue#getOperations()
	 * @see #getOperationCatalogue()
	 * @generated
	 */
	EReference getOperationCatalogue_Operations();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation <em>Enum Characteristic Changing Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Characteristic Changing Operation</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation
	 * @generated
	 */
	EClass getEnumCharacteristicChangingOperation();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation#getChange <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation#getChange()
	 * @see #getEnumCharacteristicChangingOperation()
	 * @generated
	 */
	EAttribute getEnumCharacteristicChangingOperation_Change();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperation <em>Data Transforming Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Transforming Operation</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperation
	 * @generated
	 */
	EClass getDataTransformingOperation();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperation <em>Parameterized Data Transforming Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Data Transforming Operation</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperation
	 * @generated
	 */
	EClass getParameterizedDataTransformingOperation();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecution <em>Operation Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Execution</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecution
	 * @generated
	 */
	EClass getOperationExecution();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecution#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecution#getOperation()
	 * @see #getOperationExecution()
	 * @generated
	 */
	EReference getOperationExecution_Operation();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataCharacteristicChangingOperationExecution <em>Data Characteristic Changing Operation Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Characteristic Changing Operation Execution</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataCharacteristicChangingOperationExecution
	 * @generated
	 */
	EClass getDataCharacteristicChangingOperationExecution();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataCharacteristicChangingOperationExecution#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataCharacteristicChangingOperationExecution#getData()
	 * @see #getDataCharacteristicChangingOperationExecution()
	 * @generated
	 */
	EReference getDataCharacteristicChangingOperationExecution_Data();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution <em>Enum Characteristic Changing Operation Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Characteristic Changing Operation Execution</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution
	 * @generated
	 */
	EClass getEnumCharacteristicChangingOperationExecution();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution#getEnumcharacteristicvalue <em>Enumcharacteristicvalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enumcharacteristicvalue</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution#getEnumcharacteristicvalue()
	 * @see #getEnumCharacteristicChangingOperationExecution()
	 * @generated
	 */
	EReference getEnumCharacteristicChangingOperationExecution_Enumcharacteristicvalue();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperationExecution <em>Data Transforming Operation Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Transforming Operation Execution</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperationExecution
	 * @generated
	 */
	EClass getDataTransformingOperationExecution();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperationExecution#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperationExecution#getInput()
	 * @see #getDataTransformingOperationExecution()
	 * @generated
	 */
	EReference getDataTransformingOperationExecution_Input();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperationExecution#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataTransformingOperationExecution#getOutput()
	 * @see #getDataTransformingOperationExecution()
	 * @generated
	 */
	EReference getDataTransformingOperationExecution_Output();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution <em>Parameterized Data Transforming Operation Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Data Transforming Operation Execution</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution
	 * @generated
	 */
	EClass getParameterizedDataTransformingOperationExecution();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution#getParameter()
	 * @see #getParameterizedDataTransformingOperationExecution()
	 * @generated
	 */
	EReference getParameterizedDataTransformingOperationExecution_Parameter();

	/**
	 * Returns the meta object for enum '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations <em>Enum Change Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum Change Operations</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations
	 * @generated
	 */
	EEnum getEnumChangeOperations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationsFactory getOperationsFactory();

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
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutingElementImpl <em>Operation Executing Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutingElementImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperationExecutingElement()
		 * @generated
		 */
		EClass OPERATION_EXECUTING_ELEMENT = eINSTANCE.getOperationExecutingElement();

		/**
		 * The meta object literal for the '<em><b>Operation Execution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_EXECUTING_ELEMENT__OPERATION_EXECUTION = eINSTANCE
				.getOperationExecutingElement_OperationExecution();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationCatalogueImpl <em>Operation Catalogue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationCatalogueImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperationCatalogue()
		 * @generated
		 */
		EClass OPERATION_CATALOGUE = eINSTANCE.getOperationCatalogue();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CATALOGUE__OPERATIONS = eINSTANCE.getOperationCatalogue_Operations();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationImpl <em>Enum Characteristic Changing Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getEnumCharacteristicChangingOperation()
		 * @generated
		 */
		EClass ENUM_CHARACTERISTIC_CHANGING_OPERATION = eINSTANCE.getEnumCharacteristicChangingOperation();

		/**
		 * The meta object literal for the '<em><b>Change</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE = eINSTANCE
				.getEnumCharacteristicChangingOperation_Change();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationImpl <em>Data Transforming Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getDataTransformingOperation()
		 * @generated
		 */
		EClass DATA_TRANSFORMING_OPERATION = eINSTANCE.getDataTransformingOperation();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationImpl <em>Parameterized Data Transforming Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getParameterizedDataTransformingOperation()
		 * @generated
		 */
		EClass PARAMETERIZED_DATA_TRANSFORMING_OPERATION = eINSTANCE.getParameterizedDataTransformingOperation();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutionImpl <em>Operation Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationExecutionImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getOperationExecution()
		 * @generated
		 */
		EClass OPERATION_EXECUTION = eINSTANCE.getOperationExecution();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_EXECUTION__OPERATION = eINSTANCE.getOperationExecution_Operation();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataCharacteristicChangingOperationExecutionImpl <em>Data Characteristic Changing Operation Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataCharacteristicChangingOperationExecutionImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getDataCharacteristicChangingOperationExecution()
		 * @generated
		 */
		EClass DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION = eINSTANCE
				.getDataCharacteristicChangingOperationExecution();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA = eINSTANCE
				.getDataCharacteristicChangingOperationExecution_Data();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationExecutionImpl <em>Enum Characteristic Changing Operation Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationExecutionImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getEnumCharacteristicChangingOperationExecution()
		 * @generated
		 */
		EClass ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION = eINSTANCE
				.getEnumCharacteristicChangingOperationExecution();

		/**
		 * The meta object literal for the '<em><b>Enumcharacteristicvalue</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE = eINSTANCE
				.getEnumCharacteristicChangingOperationExecution_Enumcharacteristicvalue();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationExecutionImpl <em>Data Transforming Operation Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataTransformingOperationExecutionImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getDataTransformingOperationExecution()
		 * @generated
		 */
		EClass DATA_TRANSFORMING_OPERATION_EXECUTION = eINSTANCE.getDataTransformingOperationExecution();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TRANSFORMING_OPERATION_EXECUTION__INPUT = eINSTANCE
				.getDataTransformingOperationExecution_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TRANSFORMING_OPERATION_EXECUTION__OUTPUT = eINSTANCE
				.getDataTransformingOperationExecution_Output();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationExecutionImpl <em>Parameterized Data Transforming Operation Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationExecutionImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getParameterizedDataTransformingOperationExecution()
		 * @generated
		 */
		EClass PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION = eINSTANCE
				.getParameterizedDataTransformingOperationExecution();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER = eINSTANCE
				.getParameterizedDataTransformingOperationExecution_Parameter();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations <em>Enum Change Operations</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl#getEnumChangeOperations()
		 * @generated
		 */
		EEnum ENUM_CHANGE_OPERATIONS = eINSTANCE.getEnumChangeOperations();

	}

} //OperationsPackage
