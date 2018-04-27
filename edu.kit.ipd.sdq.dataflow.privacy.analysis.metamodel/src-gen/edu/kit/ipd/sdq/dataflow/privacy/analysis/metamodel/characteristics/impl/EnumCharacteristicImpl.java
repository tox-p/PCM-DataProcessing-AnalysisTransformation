/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Characteristic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicImpl#getEnum <em>Enum</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EnumCharacteristicImpl extends CharacteristicImpl implements EnumCharacteristic {
	/**
	 * The cached value of the '{@link #getEnum() <em>Enum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnum()
	 * @generated
	 * @ordered
	 */
	protected edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum enum_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumCharacteristicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CharacteristicsPackage.Literals.ENUM_CHARACTERISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum getEnum() {
		if (enum_ != null && enum_.eIsProxy()) {
			InternalEObject oldEnum = (InternalEObject) enum_;
			enum_ = (edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum) eResolveProxy(oldEnum);
			if (enum_ != oldEnum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM, oldEnum, enum_));
			}
		}
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum basicGetEnum() {
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnum(edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum newEnum) {
		edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum oldEnum = enum_;
		enum_ = newEnum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM,
					oldEnum, enum_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM:
			if (resolve)
				return getEnum();
			return basicGetEnum();
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM:
			setEnum((edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum) newValue);
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM:
			setEnum((edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum) null);
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM:
			return enum_ != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumCharacteristicImpl
