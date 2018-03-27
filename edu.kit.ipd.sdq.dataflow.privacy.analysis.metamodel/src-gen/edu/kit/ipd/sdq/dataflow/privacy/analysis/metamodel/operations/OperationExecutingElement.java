/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Executing Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecutingElement#getOperationExecution <em>Operation Execution</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getOperationExecutingElement()
 * @model abstract="true"
 * @generated
 */
public interface OperationExecutingElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation Execution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Execution</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Execution</em>' containment reference.
	 * @see #setOperationExecution(OperationExecution)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage#getOperationExecutingElement_OperationExecution()
	 * @model containment="true"
	 * @generated
	 */
	OperationExecution<Operation> getOperationExecution();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationExecutingElement#getOperationExecution <em>Operation Execution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Execution</em>' containment reference.
	 * @see #getOperationExecution()
	 * @generated
	 */
	void setOperationExecution(OperationExecution<Operation> value);

} // OperationExecutingElement
