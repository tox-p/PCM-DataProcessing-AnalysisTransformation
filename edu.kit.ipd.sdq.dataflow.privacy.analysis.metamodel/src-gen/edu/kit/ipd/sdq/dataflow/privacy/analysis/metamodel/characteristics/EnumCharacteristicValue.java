/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Characteristic Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue#getEnumliterals <em>Enumliterals</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnumCharacteristicValue()
 * @model
 * @generated
 */
public interface EnumCharacteristicValue extends CharacteristicValue<EnumCharacteristic> {
	/**
	 * Returns the value of the '<em><b>Enumliterals</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiterals}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumliterals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumliterals</em>' reference list.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnumCharacteristicValue_Enumliterals()
	 * @model
	 * @generated
	 */
	EList<EnumLiterals> getEnumliterals();

} // EnumCharacteristicValue
