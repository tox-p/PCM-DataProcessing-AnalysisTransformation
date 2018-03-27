/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiterals;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Characteristic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicImpl#getEnumliterals <em>Enumliterals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumCharacteristicImpl extends CharacteristicImpl implements EnumCharacteristic {
	/**
	 * The cached value of the '{@link #getEnumliterals() <em>Enumliterals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumliterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumLiterals> enumliterals;

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
	public EList<EnumLiterals> getEnumliterals() {
		if (enumliterals == null) {
			enumliterals = new EObjectContainmentEList<EnumLiterals>(EnumLiterals.class, this,
					CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUMLITERALS);
		}
		return enumliterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUMLITERALS:
			return ((InternalEList<?>) getEnumliterals()).basicRemove(otherEnd, msgs);
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUMLITERALS:
			return getEnumliterals();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUMLITERALS:
			getEnumliterals().clear();
			getEnumliterals().addAll((Collection<? extends EnumLiterals>) newValue);
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUMLITERALS:
			getEnumliterals().clear();
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUMLITERALS:
			return enumliterals != null && !enumliterals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnumCharacteristicImpl
