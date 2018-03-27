/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Node;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.EntityImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.FlowImpl#getStartNode <em>Start Node</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.FlowImpl#getEndNode <em>End Node</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.FlowImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowImpl extends EntityImpl implements Flow {
	/**
	 * The cached value of the '{@link #getStartNode() <em>Start Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartNode()
	 * @generated
	 * @ordered
	 */
	protected Node startNode;

	/**
	 * The cached value of the '{@link #getEndNode() <em>End Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndNode()
	 * @generated
	 * @ordered
	 */
	protected Node endNode;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getStartNode() {
		if (startNode != null && startNode.eIsProxy()) {
			InternalEObject oldStartNode = (InternalEObject) startNode;
			startNode = (Node) eResolveProxy(oldStartNode);
			if (startNode != oldStartNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowPackage.FLOW__START_NODE,
							oldStartNode, startNode));
			}
		}
		return startNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetStartNode() {
		return startNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartNode(Node newStartNode) {
		Node oldStartNode = startNode;
		startNode = newStartNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowPackage.FLOW__START_NODE, oldStartNode,
					startNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getEndNode() {
		if (endNode != null && endNode.eIsProxy()) {
			InternalEObject oldEndNode = (InternalEObject) endNode;
			endNode = (Node) eResolveProxy(oldEndNode);
			if (endNode != oldEndNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowPackage.FLOW__END_NODE, oldEndNode,
							endNode));
			}
		}
		return endNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetEndNode() {
		return endNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndNode(Node newEndNode) {
		Node oldEndNode = endNode;
		endNode = newEndNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowPackage.FLOW__END_NODE, oldEndNode, endNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Data> getData() {
		if (data == null) {
			data = new EObjectResolvingEList<Data>(Data.class, this, FlowPackage.FLOW__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FlowPackage.FLOW__START_NODE:
			if (resolve)
				return getStartNode();
			return basicGetStartNode();
		case FlowPackage.FLOW__END_NODE:
			if (resolve)
				return getEndNode();
			return basicGetEndNode();
		case FlowPackage.FLOW__DATA:
			return getData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FlowPackage.FLOW__START_NODE:
			setStartNode((Node) newValue);
			return;
		case FlowPackage.FLOW__END_NODE:
			setEndNode((Node) newValue);
			return;
		case FlowPackage.FLOW__DATA:
			getData().clear();
			getData().addAll((Collection<? extends Data>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case FlowPackage.FLOW__START_NODE:
			setStartNode((Node) null);
			return;
		case FlowPackage.FLOW__END_NODE:
			setEndNode((Node) null);
			return;
		case FlowPackage.FLOW__DATA:
			getData().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case FlowPackage.FLOW__START_NODE:
			return startNode != null;
		case FlowPackage.FLOW__END_NODE:
			return endNode != null;
		case FlowPackage.FLOW__DATA:
			return data != null && !data.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FlowImpl
