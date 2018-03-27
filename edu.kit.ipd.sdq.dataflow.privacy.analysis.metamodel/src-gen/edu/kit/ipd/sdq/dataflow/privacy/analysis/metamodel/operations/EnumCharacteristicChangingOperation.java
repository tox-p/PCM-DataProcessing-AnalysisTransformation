/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Characteristic Changing Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation#getChange <em>Change</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getEnumCharacteristicChangingOperation()
 * @model
 * @generated
 */
public interface EnumCharacteristicChangingOperation extends Operation {
	/**
	 * Returns the value of the '<em><b>Change</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change</em>' attribute.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations
	 * @see #setChange(EnumChangeOperations)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getEnumCharacteristicChangingOperation_Change()
	 * @model
	 * @generated
	 */
	EnumChangeOperations getChange();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumCharacteristicChangingOperation#getChange <em>Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change</em>' attribute.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.EnumChangeOperations
	 * @see #getChange()
	 * @generated
	 */
	void setChange(EnumChangeOperations value);

} // EnumCharacteristicChangingOperation
