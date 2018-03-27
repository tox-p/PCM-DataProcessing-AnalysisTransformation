/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.util;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage
 * @generated
 */
public class OperationsSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsSwitch() {
		if (modelPackage == null) {
			modelPackage = OperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case OperationsPackage.OPERATION_EXECUTING_ELEMENT: {
			OperationExecutingElement operationExecutingElement = (OperationExecutingElement) theEObject;
			T1 result = caseOperationExecutingElement(operationExecutingElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.OPERATION_CATALOGUE: {
			OperationCatalogue operationCatalogue = (OperationCatalogue) theEObject;
			T1 result = caseOperationCatalogue(operationCatalogue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.OPERATION: {
			Operation operation = (Operation) theEObject;
			T1 result = caseOperation(operation);
			if (result == null)
				result = caseEntity(operation);
			if (result == null)
				result = caseIdHavingElement(operation);
			if (result == null)
				result = caseNameHavingElement(operation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION: {
			EnumCharacteristicChangingOperation enumCharacteristicChangingOperation = (EnumCharacteristicChangingOperation) theEObject;
			T1 result = caseEnumCharacteristicChangingOperation(enumCharacteristicChangingOperation);
			if (result == null)
				result = caseOperation(enumCharacteristicChangingOperation);
			if (result == null)
				result = caseEntity(enumCharacteristicChangingOperation);
			if (result == null)
				result = caseIdHavingElement(enumCharacteristicChangingOperation);
			if (result == null)
				result = caseNameHavingElement(enumCharacteristicChangingOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.DATA_TRANSFORMING_OPERATION: {
			DataTransformingOperation dataTransformingOperation = (DataTransformingOperation) theEObject;
			T1 result = caseDataTransformingOperation(dataTransformingOperation);
			if (result == null)
				result = caseOperation(dataTransformingOperation);
			if (result == null)
				result = caseEntity(dataTransformingOperation);
			if (result == null)
				result = caseIdHavingElement(dataTransformingOperation);
			if (result == null)
				result = caseNameHavingElement(dataTransformingOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION: {
			ParameterizedDataTransformingOperation parameterizedDataTransformingOperation = (ParameterizedDataTransformingOperation) theEObject;
			T1 result = caseParameterizedDataTransformingOperation(parameterizedDataTransformingOperation);
			if (result == null)
				result = caseDataTransformingOperation(parameterizedDataTransformingOperation);
			if (result == null)
				result = caseOperation(parameterizedDataTransformingOperation);
			if (result == null)
				result = caseEntity(parameterizedDataTransformingOperation);
			if (result == null)
				result = caseIdHavingElement(parameterizedDataTransformingOperation);
			if (result == null)
				result = caseNameHavingElement(parameterizedDataTransformingOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.OPERATION_EXECUTION: {
			OperationExecution<?> operationExecution = (OperationExecution<?>) theEObject;
			T1 result = caseOperationExecution(operationExecution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION: {
			EnumCharacteristicChangingOperationExecution enumCharacteristicChangingOperationExecution = (EnumCharacteristicChangingOperationExecution) theEObject;
			T1 result = caseEnumCharacteristicChangingOperationExecution(enumCharacteristicChangingOperationExecution);
			if (result == null)
				result = caseOperationExecution(enumCharacteristicChangingOperationExecution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.DATA_TRANSFORMING_OPERATION_EXECUTION: {
			DataTransformingOperationExecution<?> dataTransformingOperationExecution = (DataTransformingOperationExecution<?>) theEObject;
			T1 result = caseDataTransformingOperationExecution(dataTransformingOperationExecution);
			if (result == null)
				result = caseOperationExecution(dataTransformingOperationExecution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION: {
			ParameterizedDataTransformingOperationExecution<?> parameterizedDataTransformingOperationExecution = (ParameterizedDataTransformingOperationExecution<?>) theEObject;
			T1 result = caseParameterizedDataTransformingOperationExecution(
					parameterizedDataTransformingOperationExecution);
			if (result == null)
				result = caseDataTransformingOperationExecution(parameterizedDataTransformingOperationExecution);
			if (result == null)
				result = caseOperationExecution(parameterizedDataTransformingOperationExecution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Executing Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Executing Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationExecutingElement(OperationExecutingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Catalogue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Catalogue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationCatalogue(OperationCatalogue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Characteristic Changing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Characteristic Changing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumCharacteristicChangingOperation(EnumCharacteristicChangingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Transforming Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Transforming Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDataTransformingOperation(DataTransformingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Data Transforming Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Data Transforming Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameterizedDataTransformingOperation(ParameterizedDataTransformingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Operation> T1 caseOperationExecution(OperationExecution<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Characteristic Changing Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Characteristic Changing Operation Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumCharacteristicChangingOperationExecution(EnumCharacteristicChangingOperationExecution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Transforming Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Transforming Operation Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends DataTransformingOperation> T1 caseDataTransformingOperationExecution(
			DataTransformingOperationExecution<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Data Transforming Operation Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Data Transforming Operation Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends ParameterizedDataTransformingOperation> T1 caseParameterizedDataTransformingOperationExecution(
			ParameterizedDataTransformingOperationExecution<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Having Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Having Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdHavingElement(IdHavingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Having Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Having Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNameHavingElement(NameHavingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //OperationsSwitch
