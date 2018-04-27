/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiteral;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Characteristic Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.EnumCharacteristicValueImpl#getEnumliterals <em>Enumliterals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumCharacteristicValueImpl extends CharacteristicValueImpl<EnumCharacteristic>
		implements EnumCharacteristicValue {
	/**
	 * The cached value of the '{@link #getEnumliterals() <em>Enumliterals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumliterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumLiteral> enumliterals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumCharacteristicValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CharacteristicsPackage.Literals.ENUM_CHARACTERISTIC_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setCharacteristic(EnumCharacteristic newCharacteristic) {
		super.setCharacteristic(newCharacteristic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumLiteral> getEnumliterals() {
		if (enumliterals == null) {
			enumliterals = new EObjectResolvingEList<EnumLiteral>(EnumLiteral.class, this,
					CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS);
		}
		return enumliterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS:
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS:
			getEnumliterals().clear();
			getEnumliterals().addAll((Collection<? extends EnumLiteral>) newValue);
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS:
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
		case CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE__ENUMLITERALS:
			return enumliterals != null && !enumliterals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnumCharacteristicValueImpl
