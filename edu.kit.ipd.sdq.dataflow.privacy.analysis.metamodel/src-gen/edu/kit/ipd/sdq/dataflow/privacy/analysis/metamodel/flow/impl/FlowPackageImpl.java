/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.MetamodelPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsPackageImpl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.DataFlowDiagram;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowEnd;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowFactory;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowNode;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowStart;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Node;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.NodeContainer;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.impl.OperationsPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowPackageImpl extends EPackageImpl implements FlowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FlowPackageImpl() {
		super(eNS_URI, FlowFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FlowPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FlowPackage init() {
		if (isInited)
			return (FlowPackage) EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);

		// Obtain or create and register package
		FlowPackageImpl theFlowPackage = (FlowPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof FlowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new FlowPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(MetamodelPackage.eNS_URI) instanceof MetamodelPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI)
						: MetamodelPackage.eINSTANCE);
		CharacteristicsPackageImpl theCharacteristicsPackage = (CharacteristicsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(CharacteristicsPackage.eNS_URI) instanceof CharacteristicsPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(CharacteristicsPackage.eNS_URI)
						: CharacteristicsPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI)
						: OperationsPackage.eINSTANCE);

		// Create package meta-data objects
		theFlowPackage.createPackageContents();
		theMetamodelPackage.createPackageContents();
		theCharacteristicsPackage.createPackageContents();
		theOperationsPackage.createPackageContents();

		// Initialize created meta-data
		theFlowPackage.initializePackageContents();
		theMetamodelPackage.initializePackageContents();
		theCharacteristicsPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFlowPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FlowPackage.eNS_URI, theFlowPackage);
		return theFlowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFlowDiagram() {
		return dataFlowDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowDiagram_Nodecontainer() {
		return (EReference) dataFlowDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowDiagram_Data() {
		return (EReference) dataFlowDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowDiagram_Flow() {
		return (EReference) dataFlowDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeContainer() {
		return nodeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeContainer_Nodes() {
		return (EReference) nodeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowStart() {
		return flowStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowEnd() {
		return flowEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowNode() {
		return flowNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlow() {
		return flowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_StartNode() {
		return (EReference) flowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_EndNode() {
		return (EReference) flowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_Data() {
		return (EReference) flowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getData() {
		return dataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFactory getFlowFactory() {
		return (FlowFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		dataFlowDiagramEClass = createEClass(DATA_FLOW_DIAGRAM);
		createEReference(dataFlowDiagramEClass, DATA_FLOW_DIAGRAM__NODECONTAINER);
		createEReference(dataFlowDiagramEClass, DATA_FLOW_DIAGRAM__DATA);
		createEReference(dataFlowDiagramEClass, DATA_FLOW_DIAGRAM__FLOW);

		nodeContainerEClass = createEClass(NODE_CONTAINER);
		createEReference(nodeContainerEClass, NODE_CONTAINER__NODES);

		nodeEClass = createEClass(NODE);

		flowStartEClass = createEClass(FLOW_START);

		flowEndEClass = createEClass(FLOW_END);

		flowNodeEClass = createEClass(FLOW_NODE);

		flowEClass = createEClass(FLOW);
		createEReference(flowEClass, FLOW__START_NODE);
		createEReference(flowEClass, FLOW__END_NODE);
		createEReference(flowEClass, FLOW__DATA);

		dataEClass = createEClass(DATA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CharacteristicsPackage theCharacteristicsPackage = (CharacteristicsPackage) EPackage.Registry.INSTANCE
				.getEPackage(CharacteristicsPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(MetamodelPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage) EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nodeContainerEClass.getESuperTypes().add(theCharacteristicsPackage.getCharacteristicsHavingElement());
		nodeContainerEClass.getESuperTypes().add(theMetamodelPackage.getEntity());
		nodeEClass.getESuperTypes().add(theMetamodelPackage.getEntity());
		flowStartEClass.getESuperTypes().add(this.getNode());
		flowEndEClass.getESuperTypes().add(this.getNode());
		flowNodeEClass.getESuperTypes().add(this.getNode());
		flowNodeEClass.getESuperTypes().add(theOperationsPackage.getOperationExecutingElement());
		flowEClass.getESuperTypes().add(theMetamodelPackage.getEntity());
		dataEClass.getESuperTypes().add(theMetamodelPackage.getEntity());
		dataEClass.getESuperTypes().add(theCharacteristicsPackage.getCharacteristicsHavingElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(dataFlowDiagramEClass, DataFlowDiagram.class, "DataFlowDiagram", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlowDiagram_Nodecontainer(), this.getNodeContainer(), null, "nodecontainer", null, 0, -1,
				DataFlowDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFlowDiagram_Data(), this.getData(), null, "data", null, 0, -1, DataFlowDiagram.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFlowDiagram_Flow(), this.getFlow(), null, "flow", null, 0, -1, DataFlowDiagram.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeContainerEClass, NodeContainer.class, "NodeContainer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeContainer_Nodes(), this.getNode(), null, "nodes", null, 0, -1, NodeContainer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(flowStartEClass, FlowStart.class, "FlowStart", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(flowEndEClass, FlowEnd.class, "FlowEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(flowNodeEClass, FlowNode.class, "FlowNode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(flowEClass, Flow.class, "Flow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlow_StartNode(), this.getNode(), null, "startNode", null, 1, 1, Flow.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getFlow_EndNode(), this.getNode(), null, "endNode", null, 1, 1, Flow.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getFlow_Data(), this.getData(), null, "data", null, 1, -1, Flow.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(dataEClass, Data.class, "Data", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //FlowPackageImpl
