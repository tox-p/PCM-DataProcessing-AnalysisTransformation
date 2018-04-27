/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterized Data Transforming Operation Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getParameterizedDataTransformingOperationExecution()
 * @model
 * @generated
 */
public interface ParameterizedDataTransformingOperationExecution<T extends ParameterizedDataTransformingOperation>
		extends DataTransformingOperationExecution<T> {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Data)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getParameterizedDataTransformingOperationExecution_Parameter()
	 * @model required="true"
	 * @generated
	 */
	Data getParameter();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.ParameterizedDataTransformingOperationExecution#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Data value);

} // ParameterizedDataTransformingOperationExecution
