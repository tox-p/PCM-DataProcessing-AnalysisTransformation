/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Characteristic Changing Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.EnumCharacteristicChangingOperationImpl#getChange <em>Change</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumCharacteristicChangingOperationImpl extends OperationImpl
		implements EnumCharacteristicChangingOperation {
	/**
	 * The default value of the '{@link #getChange() <em>Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChange()
	 * @generated
	 * @ordered
	 */
	protected static final EnumChangeOperations CHANGE_EDEFAULT = EnumChangeOperations.ADD;

	/**
	 * The cached value of the '{@link #getChange() <em>Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChange()
	 * @generated
	 * @ordered
	 */
	protected EnumChangeOperations change = CHANGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumCharacteristicChangingOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.ENUM_CHARACTERISTIC_CHANGING_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumChangeOperations getChange() {
		return change;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChange(EnumChangeOperations newChange) {
		EnumChangeOperations oldChange = change;
		change = newChange == null ? CHANGE_EDEFAULT : newChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE, oldChange, change));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE:
			return getChange();
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
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE:
			setChange((EnumChangeOperations) newValue);
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
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE:
			setChange(CHANGE_EDEFAULT);
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
		case OperationsPackage.ENUM_CHARACTERISTIC_CHANGING_OPERATION__CHANGE:
			return change != CHANGE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (change: ");
		result.append(change);
		result.append(')');
		return result.toString();
	}

} //EnumCharacteristicChangingOperationImpl
