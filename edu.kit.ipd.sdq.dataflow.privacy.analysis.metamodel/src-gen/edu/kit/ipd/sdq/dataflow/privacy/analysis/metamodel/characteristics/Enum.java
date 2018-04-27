/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnum()
 * @model
 * @generated
 */
public interface Enum extends Entity {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnum_Literals()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumLiteral> getLiterals();

} // Enum
