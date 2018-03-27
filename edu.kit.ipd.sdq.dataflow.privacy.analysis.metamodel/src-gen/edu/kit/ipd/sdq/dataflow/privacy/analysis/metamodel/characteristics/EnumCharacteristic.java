/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Characteristic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic#getEnumliterals <em>Enumliterals</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnumCharacteristic()
 * @model
 * @generated
 */
public interface EnumCharacteristic extends Characteristic {
	/**
	 * Returns the value of the '<em><b>Enumliterals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiterals}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumliterals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumliterals</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnumCharacteristic_Enumliterals()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumLiterals> getEnumliterals();

} // EnumCharacteristic
