/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Characteristic Changing Operation Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataCharacteristicChangingOperationExecution#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getDataCharacteristicChangingOperationExecution()
 * @model
 * @generated
 */
public interface DataCharacteristicChangingOperationExecution<T extends Operation> extends OperationExecution<T> {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference.
	 * @see #setData(Data)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getDataCharacteristicChangingOperationExecution_Data()
	 * @model required="true"
	 * @generated
	 */
	Data getData();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.DataCharacteristicChangingOperationExecution#getData <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(Data value);

} // DataCharacteristicChangingOperationExecution
