/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Characteristic Changing Operation Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationExecutionImpl#getEnumcharacteristicvalue <em>Enumcharacteristicvalue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumCharacteristicChangingOperationExecutionImpl
		extends DataCharacteristicChangingOperationExecutionImpl<EnumCharacteristicChangingOperation>
		implements EnumCharacteristicChangingOperationExecution {
	/**
	 * The cached value of the '{@link #getEnumcharacteristicvalue() <em>Enumcharacteristicvalue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumcharacteristicvalue()
	 * @generated
	 * @ordered
	 */
	protected EnumCharacteristicValue enumcharacteristicvalue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumCharacteristicChangingOperationExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristicValue getEnumcharacteristicvalue() {
		return enumcharacteristicvalue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnumcharacteristicvalue(EnumCharacteristicValue newEnumcharacteristicvalue,
			NotificationChain msgs) {
		EnumCharacteristicValue oldEnumcharacteristicvalue = enumcharacteristicvalue;
		enumcharacteristicvalue = newEnumcharacteristicvalue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE,
					oldEnumcharacteristicvalue, newEnumcharacteristicvalue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumcharacteristicvalue(EnumCharacteristicValue newEnumcharacteristicvalue) {
		if (newEnumcharacteristicvalue != enumcharacteristicvalue) {
			NotificationChain msgs = null;
			if (enumcharacteristicvalue != null)
				msgs = ((InternalEObject) enumcharacteristicvalue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE,
						null, msgs);
			if (newEnumcharacteristicvalue != null)
				msgs = ((InternalEObject) newEnumcharacteristicvalue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE,
						null, msgs);
			msgs = basicSetEnumcharacteristicvalue(newEnumcharacteristicvalue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE,
					newEnumcharacteristicvalue, newEnumcharacteristicvalue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE:
			return basicSetEnumcharacteristicvalue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE:
			return getEnumcharacteristicvalue();
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
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE:
			setEnumcharacteristicvalue((EnumCharacteristicValue) newValue);
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
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE:
			setEnumcharacteristicvalue((EnumCharacteristicValue) null);
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
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION_EXECUTION__ENUMCHARACTERISTICVALUE:
			return enumcharacteristicvalue != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumCharacteristicChangingOperationExecutionImpl
