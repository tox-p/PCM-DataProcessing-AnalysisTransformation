/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow#getStartNode <em>Start Node</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow#getEndNode <em>End Node</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage#getFlow()
 * @model
 * @generated
 */
public interface Flow extends Entity {
	/**
	 * Returns the value of the '<em><b>Start Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Node</em>' reference.
	 * @see #setStartNode(Node)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage#getFlow_StartNode()
	 * @model required="true"
	 * @generated
	 */
	Node getStartNode();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow#getStartNode <em>Start Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Node</em>' reference.
	 * @see #getStartNode()
	 * @generated
	 */
	void setStartNode(Node value);

	/**
	 * Returns the value of the '<em><b>End Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Node</em>' reference.
	 * @see #setEndNode(Node)
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage#getFlow_EndNode()
	 * @model required="true"
	 * @generated
	 */
	Node getEndNode();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow#getEndNode <em>End Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Node</em>' reference.
	 * @see #getEndNode()
	 * @generated
	 */
	void setEndNode(Node value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference list.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage#getFlow_Data()
	 * @model required="true"
	 * @generated
	 */
	EList<Data> getData();

} // Flow
