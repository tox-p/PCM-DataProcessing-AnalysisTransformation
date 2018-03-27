/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.NodeContainer#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage#getNodeContainer()
 * @model
 * @generated
 */
public interface NodeContainer extends CharacteristicsHavingElement, Entity {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage#getNodeContainer_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

} // NodeContainer
