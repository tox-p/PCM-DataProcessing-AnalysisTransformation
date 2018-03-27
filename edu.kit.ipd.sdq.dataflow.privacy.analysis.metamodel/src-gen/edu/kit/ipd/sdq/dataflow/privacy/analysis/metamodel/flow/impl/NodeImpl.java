/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Node;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.EntityImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class NodeImpl extends EntityImpl implements Node {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.NODE;
	}

} //NodeImpl
