/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage
 * @generated
 */
public interface OperationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsFactory eINSTANCE = edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Operation Catalogue</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Catalogue</em>'.
	 * @generated
	 */
	OperationCatalogue createOperationCatalogue();

	/**
	 * Returns a new object of class '<em>Enum Characteristic Changing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Characteristic Changing Operation</em>'.
	 * @generated
	 */
	EnumCharacteristicChangingOperation createEnumCharacteristicChangingOperation();

	/**
	 * Returns a new object of class '<em>Data Transforming Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Transforming Operation</em>'.
	 * @generated
	 */
	DataTransformingOperation createDataTransformingOperation();

	/**
	 * Returns a new object of class '<em>Parameterized Data Transforming Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameterized Data Transforming Operation</em>'.
	 * @generated
	 */
	ParameterizedDataTransformingOperation createParameterizedDataTransformingOperation();

	/**
	 * Returns a new object of class '<em>Data Characteristic Changing Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Characteristic Changing Operation Execution</em>'.
	 * @generated
	 */
	<T extends Operation> DataCharacteristicChangingOperationExecution<T> createDataCharacteristicChangingOperationExecution();

	/**
	 * Returns a new object of class '<em>Enum Characteristic Changing Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Characteristic Changing Operation Execution</em>'.
	 * @generated
	 */
	EnumCharacteristicChangingOperationExecution createEnumCharacteristicChangingOperationExecution();

	/**
	 * Returns a new object of class '<em>Data Transforming Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Transforming Operation Execution</em>'.
	 * @generated
	 */
	<T extends DataTransformingOperation> DataTransformingOperationExecution<T> createDataTransformingOperationExecution();

	/**
	 * Returns a new object of class '<em>Parameterized Data Transforming Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameterized Data Transforming Operation Execution</em>'.
	 * @generated
	 */
	<T extends ParameterizedDataTransformingOperation> ParameterizedDataTransformingOperationExecution<T> createParameterizedDataTransformingOperationExecution();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationsPackage getOperationsPackage();

} //OperationsFactory
