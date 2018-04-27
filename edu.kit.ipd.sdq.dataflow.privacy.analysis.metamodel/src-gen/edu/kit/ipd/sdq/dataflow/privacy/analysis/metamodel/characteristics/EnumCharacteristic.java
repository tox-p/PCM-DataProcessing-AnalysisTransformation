/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Characteristic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic#getEnum <em>Enum</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnumCharacteristic()
 * @model abstract="true"
 * @generated
 */
public interface EnumCharacteristic extends Characteristic {
	/**
	 * Returns the value of the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum</em>' reference.
	 * @see #setEnum(edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage#getEnumCharacteristic_Enum()
	 * @model required="true"
	 * @generated
	 */
	edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum getEnum();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic#getEnum <em>Enum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum</em>' reference.
	 * @see #getEnum()
	 * @generated
	 */
	void setEnum(edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum value);

} // EnumCharacteristic
