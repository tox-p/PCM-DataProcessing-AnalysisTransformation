/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.DataFlowDiagram;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.NodeContainer;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.DataFlowDiagramImpl#getNodecontainer <em>Nodecontainer</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.DataFlowDiagramImpl#getData <em>Data</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl.DataFlowDiagramImpl#getFlow <em>Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataFlowDiagramImpl extends MinimalEObjectImpl.Container implements DataFlowDiagram {
	/**
	 * The cached value of the '{@link #getNodecontainer() <em>Nodecontainer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodecontainer()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeContainer> nodecontainer;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> data;

	/**
	 * The cached value of the '{@link #getFlow() <em>Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlow()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> flow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.DATA_FLOW_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeContainer> getNodecontainer() {
		if (nodecontainer == null) {
			nodecontainer = new EObjectContainmentEList<NodeContainer>(NodeContainer.class, this,
					FlowPackage.DATA_FLOW_DIAGRAM__NODECONTAINER);
		}
		return nodecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Data> getData() {
		if (data == null) {
			data = new EObjectContainmentEList<Data>(Data.class, this, FlowPackage.DATA_FLOW_DIAGRAM__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Flow> getFlow() {
		if (flow == null) {
			flow = new EObjectContainmentEList<Flow>(Flow.class, this, FlowPackage.DATA_FLOW_DIAGRAM__FLOW);
		}
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FlowPackage.DATA_FLOW_DIAGRAM__NODECONTAINER:
			return ((InternalEList<?>) getNodecontainer()).basicRemove(otherEnd, msgs);
		case FlowPackage.DATA_FLOW_DIAGRAM__DATA:
			return ((InternalEList<?>) getData()).basicRemove(otherEnd, msgs);
		case FlowPackage.DATA_FLOW_DIAGRAM__FLOW:
			return ((InternalEList<?>) getFlow()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FlowPackage.DATA_FLOW_DIAGRAM__NODECONTAINER:
			return getNodecontainer();
		case FlowPackage.DATA_FLOW_DIAGRAM__DATA:
			return getData();
		case FlowPackage.DATA_FLOW_DIAGRAM__FLOW:
			return getFlow();
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
		case FlowPackage.DATA_FLOW_DIAGRAM__NODECONTAINER:
			getNodecontainer().clear();
			getNodecontainer().addAll((Collection<? extends NodeContainer>) newValue);
			return;
		case FlowPackage.DATA_FLOW_DIAGRAM__DATA:
			getData().clear();
			getData().addAll((Collection<? extends Data>) newValue);
			return;
		case FlowPackage.DATA_FLOW_DIAGRAM__FLOW:
			getFlow().clear();
			getFlow().addAll((Collection<? extends Flow>) newValue);
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
		case FlowPackage.DATA_FLOW_DIAGRAM__NODECONTAINER:
			getNodecontainer().clear();
			return;
		case FlowPackage.DATA_FLOW_DIAGRAM__DATA:
			getData().clear();
			return;
		case FlowPackage.DATA_FLOW_DIAGRAM__FLOW:
			getFlow().clear();
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
		case FlowPackage.DATA_FLOW_DIAGRAM__NODECONTAINER:
			return nodecontainer != null && !nodecontainer.isEmpty();
		case FlowPackage.DATA_FLOW_DIAGRAM__DATA:
			return data != null && !data.isEmpty();
		case FlowPackage.DATA_FLOW_DIAGRAM__FLOW:
			return flow != null && !flow.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataFlowDiagramImpl
