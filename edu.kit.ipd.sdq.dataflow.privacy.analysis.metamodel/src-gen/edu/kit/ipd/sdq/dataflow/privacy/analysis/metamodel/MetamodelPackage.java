/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.MetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface MetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.kit.edu/dataflow/privacy/analysis/mm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelPackage eINSTANCE = edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.IdHavingElementImpl <em>Id Having Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.IdHavingElementImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl#getIdHavingElement()
	 * @generated
	 */
	int ID_HAVING_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_HAVING_ELEMENT__ID = 0;

	/**
	 * The number of structural features of the '<em>Id Having Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_HAVING_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Id Having Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_HAVING_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.NameHavingElementImpl <em>Name Having Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.NameHavingElementImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl#getNameHavingElement()
	 * @generated
	 */
	int NAME_HAVING_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_HAVING_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Name Having Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_HAVING_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Name Having Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_HAVING_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.EntityImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ID = ID_HAVING_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = ID_HAVING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = ID_HAVING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = ID_HAVING_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement <em>Id Having Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id Having Element</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement
	 * @generated
	 */
	EClass getIdHavingElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement#getId()
	 * @see #getIdHavingElement()
	 * @generated
	 */
	EAttribute getIdHavingElement_Id();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement <em>Name Having Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Having Element</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement
	 * @generated
	 */
	EClass getNameHavingElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement#getName()
	 * @see #getNameHavingElement()
	 * @generated
	 */
	EAttribute getNameHavingElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetamodelFactory getMetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.IdHavingElementImpl <em>Id Having Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.IdHavingElementImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl#getIdHavingElement()
		 * @generated
		 */
		EClass ID_HAVING_ELEMENT = eINSTANCE.getIdHavingElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_HAVING_ELEMENT__ID = eINSTANCE.getIdHavingElement_Id();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.NameHavingElementImpl <em>Name Having Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.NameHavingElementImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl#getNameHavingElement()
		 * @generated
		 */
		EClass NAME_HAVING_ELEMENT = eINSTANCE.getNameHavingElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_HAVING_ELEMENT__NAME = eINSTANCE.getNameHavingElement_Name();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.EntityImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.impl.MetamodelPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

	}

} //MetamodelPackage
