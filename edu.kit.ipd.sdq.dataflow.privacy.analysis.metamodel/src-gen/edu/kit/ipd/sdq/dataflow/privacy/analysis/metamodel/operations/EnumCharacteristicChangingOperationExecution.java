/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Characteristic Changing Operation Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution#getEnumcharacteristicvalue <em>Enumcharacteristicvalue</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getEnumCharacteristicChangingOperationExecution()
 * @model
 * @generated
 */
public interface EnumCharacteristicChangingOperationExecution
		extends OperationExecution<EnumCharacteristicChangingOperation> {
	/**
	 * Returns the value of the '<em><b>Enumcharacteristicvalue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumcharacteristicvalue</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumcharacteristicvalue</em>' containment reference.
	 * @see #setEnumcharacteristicvalue(EnumCharacteristicValue)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getEnumCharacteristicChangingOperationExecution_Enumcharacteristicvalue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EnumCharacteristicValue getEnumcharacteristicvalue();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperationExecution#getEnumcharacteristicvalue <em>Enumcharacteristicvalue</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumcharacteristicvalue</em>' containment reference.
	 * @see #getEnumcharacteristicvalue()
	 * @generated
	 */
	void setEnumcharacteristicvalue(EnumCharacteristicValue value);

} // EnumCharacteristicChangingOperationExecution
