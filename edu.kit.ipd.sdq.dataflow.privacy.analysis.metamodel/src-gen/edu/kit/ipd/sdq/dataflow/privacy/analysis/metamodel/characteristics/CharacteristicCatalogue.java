/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characteristic Catalogue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue#getCharacteristics <em>Characteristics</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue#getOwnedEntities <em>Owned Entities</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getCharacteristicCatalogue()
 * @model
 * @generated
 */
public interface CharacteristicCatalogue extends EObject {
	/**
	 * Returns the value of the '<em><b>Characteristics</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characteristics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristics</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getCharacteristicCatalogue_Characteristics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Characteristic> getCharacteristics();

	/**
	 * Returns the value of the '<em><b>Owned Entities</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Entities</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getCharacteristicCatalogue_OwnedEntities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getOwnedEntities();

} // CharacteristicCatalogue
