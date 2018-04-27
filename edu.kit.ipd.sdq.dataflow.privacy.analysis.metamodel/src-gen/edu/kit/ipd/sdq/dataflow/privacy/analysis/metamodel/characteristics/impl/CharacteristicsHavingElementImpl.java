/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Having Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsHavingElementImpl#getCharacteristic <em>Characteristic</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CharacteristicsHavingElementImpl extends MinimalEObjectImpl.Container
		implements CharacteristicsHavingElement {
	/**
	 * The cached value of the '{@link #getCharacteristic() <em>Characteristic</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristic()
	 * @generated
	 * @ordered
	 */
	protected EList<CharacteristicValue<Characteristic>> characteristic;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacteristicsHavingElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CharacteristicsPackage.Literals.CHARACTERISTICS_HAVING_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CharacteristicValue<Characteristic>> getCharacteristic() {
		if (characteristic == null) {
			characteristic = new EObjectContainmentEList<CharacteristicValue<Characteristic>>(CharacteristicValue.class,
					this, CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC);
		}
		return characteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC:
			return ((InternalEList<?>) getCharacteristic()).basicRemove(otherEnd, msgs);
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
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC:
			return getCharacteristic();
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
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC:
			getCharacteristic().clear();
			getCharacteristic().addAll((Collection<? extends CharacteristicValue<Characteristic>>) newValue);
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
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC:
			getCharacteristic().clear();
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
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT__CHARACTERISTIC:
			return characteristic != null && !characteristic.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CharacteristicsHavingElementImpl
