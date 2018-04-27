/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataCharacteristicChangingOperationExecution;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.Operation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Characteristic Changing Operation Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.DataCharacteristicChangingOperationExecutionImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataCharacteristicChangingOperationExecutionImpl<T extends Operation> extends OperationExecutionImpl<T>
		implements DataCharacteristicChangingOperationExecution<T> {
	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected Data data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataCharacteristicChangingOperationExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data getData() {
		if (data != null && data.eIsProxy()) {
			InternalEObject oldData = (InternalEObject) data;
			data = (Data) eResolveProxy(oldData);
			if (data != oldData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OperationsPackage.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA, oldData, data));
			}
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data basicGetData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(Data newData) {
		Data oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA:
			if (resolve)
				return getData();
			return basicGetData();
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
		case OperationsPackage.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA:
			setData((Data) newValue);
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
		case OperationsPackage.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA:
			setData((Data) null);
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
		case OperationsPackage.DATA_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__DATA:
			return data != null;
		}
		return super.eIsSet(featureID);
	}

} //DataCharacteristicChangingOperationExecutionImpl
