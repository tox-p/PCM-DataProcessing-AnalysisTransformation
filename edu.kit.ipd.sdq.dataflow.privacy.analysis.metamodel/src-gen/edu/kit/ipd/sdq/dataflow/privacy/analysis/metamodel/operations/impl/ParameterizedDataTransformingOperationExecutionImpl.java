/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Data Transforming Operation Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.ParameterizedDataTransformingOperationExecutionImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterizedDataTransformingOperationExecutionImpl<T extends ParameterizedDataTransformingOperation>
		extends DataTransformingOperationExecutionImpl<T>
		implements ParameterizedDataTransformingOperationExecution<T> {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected Data parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterizedDataTransformingOperationExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject) parameter;
			parameter = (Data) eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER,
							oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(Data newParameter) {
		Data oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER, oldParameter,
					parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER:
			if (resolve)
				return getParameter();
			return basicGetParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER:
			setParameter((Data) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER:
			setParameter((Data) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OperationsPackage.PARAMETERIZED_DATA_TRANSFORMING_OPERATION_EXECUTION__PARAMETER:
			return parameter != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterizedDataTransformingOperationExecutionImpl
