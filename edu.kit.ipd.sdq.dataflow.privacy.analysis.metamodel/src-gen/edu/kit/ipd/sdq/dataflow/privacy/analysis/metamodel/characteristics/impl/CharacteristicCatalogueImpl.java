/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue;
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
 * An implementation of the model object '<em><b>Characteristic Catalogue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicCatalogueImpl#getCharacteristics <em>Characteristics</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicCatalogueImpl#getOwnedEntities <em>Owned Entities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CharacteristicCatalogueImpl extends MinimalEObjectImpl.Container implements CharacteristicCatalogue {
	/**
	 * The cached value of the '{@link #getCharacteristics() <em>Characteristics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristics()
	 * @generated
	 * @ordered
	 */
	protected EList<Characteristic> characteristics;

	/**
	 * The cached value of the '{@link #getOwnedEntities() <em>Owned Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> ownedEntities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacteristicCatalogueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Characteristic> getCharacteristics() {
		if (characteristics == null) {
			characteristics = new EObjectContainmentEList<Characteristic>(Characteristic.class, this,
					CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS);
		}
		return characteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entity> getOwnedEntities() {
		if (ownedEntities == null) {
			ownedEntities = new EObjectContainmentEList<Entity>(Entity.class, this,
					CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES);
		}
		return ownedEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS:
			return ((InternalEList<?>) getCharacteristics()).basicRemove(otherEnd, msgs);
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES:
			return ((InternalEList<?>) getOwnedEntities()).basicRemove(otherEnd, msgs);
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
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS:
			return getCharacteristics();
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES:
			return getOwnedEntities();
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
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS:
			getCharacteristics().clear();
			getCharacteristics().addAll((Collection<? extends Characteristic>) newValue);
			return;
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES:
			getOwnedEntities().clear();
			getOwnedEntities().addAll((Collection<? extends Entity>) newValue);
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
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS:
			getCharacteristics().clear();
			return;
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES:
			getOwnedEntities().clear();
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
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS:
			return characteristics != null && !characteristics.isEmpty();
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES:
			return ownedEntities != null && !ownedEntities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CharacteristicCatalogueImpl
