/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class OperationsFactoryImpl extends EFactoryImpl implements OperationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperationsFactory init() {
		try {
			OperationsFactory theOperationsFactory = (OperationsFactory) EPackage.Registry.INSTANCE
					.getEFactory(OperationsPackage.eNS_URI);
			if (theOperationsFactory != null) {
				return theOperationsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactoryImpl() {
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
		case OperationsPackage.OPERATION_CATALOGUE:
			return createOperationCatalogue();
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION:
			return createEnumCharacteristicChangingOperation();
		case OperationsPackage.DATA_TRANSFORMING_OPERATION:
			return createDataTransformingOperation();
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION:
			return createParameterizedDataTransformingOperation();
		case OperationsPackage.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION:
			return createDataCharacteristicChangingOperationExecution();
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION:
			return createEnumCharacteristicChangingOperationExecution();
		case OperationsPackage.DATA_TRANSFORMING_OPERATION_EXECUTION:
			return createDataTransformingOperationExecution();
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION:
			return createParameterizedDataTransformingOperationExecution();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case OperationsPackage.ENUM_CHANGE_OPERATIONS:
			return createEnumChangeOperationsFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case OperationsPackage.ENUM_CHANGE_OPERATIONS:
			return convertEnumChangeOperationsToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCatalogue createOperationCatalogue() {
		OperationCatalogueImpl operationCatalogue = new OperationCatalogueImpl();
		return operationCatalogue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristicChangingOperation createEnumCharacteristicChangingOperation() {
		EnumCharacteristicChangingOperationImpl enumCharacteristicChangingOperation = new EnumCharacteristicChangingOperationImpl();
		return enumCharacteristicChangingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTransformingOperation createDataTransformingOperation() {
		DataTransformingOperationImpl dataTransformingOperation = new DataTransformingOperationImpl();
		return dataTransformingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedDataTransformingOperation createParameterizedDataTransformingOperation() {
		ParameterizedDataTransformingOperationImpl parameterizedDataTransformingOperation = new ParameterizedDataTransformingOperationImpl();
		return parameterizedDataTransformingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Operation> DataCharacteristicChangingOperationExecution<T> createDataCharacteristicChangingOperationExecution() {
		DataCharacteristicChangingOperationExecutionImpl<T> dataCharacteristicChangingOperationExecution = new DataCharacteristicChangingOperationExecutionImpl<T>();
		return dataCharacteristicChangingOperationExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristicChangingOperationExecution createEnumCharacteristicChangingOperationExecution() {
		EnumCharacteristicChangingOperationExecutionImpl enumCharacteristicChangingOperationExecution = new EnumCharacteristicChangingOperationExecutionImpl();
		return enumCharacteristicChangingOperationExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends DataTransformingOperation> DataTransformingOperationExecution<T> createDataTransformingOperationExecution() {
		DataTransformingOperationExecutionImpl<T> dataTransformingOperationExecution = new DataTransformingOperationExecutionImpl<T>();
		return dataTransformingOperationExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends ParameterizedDataTransformingOperation> ParameterizedDataTransformingOperationExecution<T> createParameterizedDataTransformingOperationExecution() {
		ParameterizedDataTransformingOperationExecutionImpl<T> parameterizedDataTransformingOperationExecution = new ParameterizedDataTransformingOperationExecutionImpl<T>();
		return parameterizedDataTransformingOperationExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumChangeOperations createEnumChangeOperationsFromString(EDataType eDataType, String initialValue) {
		EnumChangeOperations result = EnumChangeOperations.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumChangeOperationsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsPackage getOperationsPackage() {
		return (OperationsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperationsPackage getPackage() {
		return OperationsPackage.eINSTANCE;
	}

} //OperationsFactoryImpl
