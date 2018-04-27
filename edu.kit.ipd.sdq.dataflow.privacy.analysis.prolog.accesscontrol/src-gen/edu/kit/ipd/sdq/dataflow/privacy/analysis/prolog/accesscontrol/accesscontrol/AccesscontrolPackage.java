/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;

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
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccesscontrolFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import characteristics='../../edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel/model/metamodel.ecore#//characteristics'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface AccesscontrolPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "accesscontrol";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.kit.edu/dataflow/privacy/analysis/mm/accesscontrol";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "accesscontrol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AccesscontrolPackage eINSTANCE = edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccesscontrolPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccessControlCharacteristicImpl <em>Access Control Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccessControlCharacteristicImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccesscontrolPackageImpl#getAccessControlCharacteristic()
	 * @generated
	 */
	int ACCESS_CONTROL_CHARACTERISTIC = 1;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.RoleCharacteristicImpl <em>Role Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.RoleCharacteristicImpl
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccesscontrolPackageImpl#getRoleCharacteristic()
	 * @generated
	 */
	int ROLE_CHARACTERISTIC = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CHARACTERISTIC__ID = CharacteristicsPackage.ENUM_CHARACTERISTIC__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CHARACTERISTIC__NAME = CharacteristicsPackage.ENUM_CHARACTERISTIC__NAME;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CHARACTERISTIC__ENUM = CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM;

	/**
	 * The number of structural features of the '<em>Role Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CHARACTERISTIC_FEATURE_COUNT = CharacteristicsPackage.ENUM_CHARACTERISTIC_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Role Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CHARACTERISTIC_OPERATION_COUNT = CharacteristicsPackage.ENUM_CHARACTERISTIC_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHARACTERISTIC__ID = CharacteristicsPackage.ENUM_CHARACTERISTIC__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHARACTERISTIC__NAME = CharacteristicsPackage.ENUM_CHARACTERISTIC__NAME;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHARACTERISTIC__ENUM = CharacteristicsPackage.ENUM_CHARACTERISTIC__ENUM;

	/**
	 * The number of structural features of the '<em>Access Control Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHARACTERISTIC_FEATURE_COUNT = CharacteristicsPackage.ENUM_CHARACTERISTIC_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Access Control Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CHARACTERISTIC_OPERATION_COUNT = CharacteristicsPackage.ENUM_CHARACTERISTIC_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccessControlCharacteristic <em>Access Control Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Control Characteristic</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccessControlCharacteristic
	 * @generated
	 */
	EClass getAccessControlCharacteristic();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.RoleCharacteristic <em>Role Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Characteristic</em>'.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.RoleCharacteristic
	 * @generated
	 */
	EClass getRoleCharacteristic();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AccesscontrolFactory getAccesscontrolFactory();

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
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccessControlCharacteristicImpl <em>Access Control Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccessControlCharacteristicImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccesscontrolPackageImpl#getAccessControlCharacteristic()
		 * @generated
		 */
		EClass ACCESS_CONTROL_CHARACTERISTIC = eINSTANCE.getAccessControlCharacteristic();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.RoleCharacteristicImpl <em>Role Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.RoleCharacteristicImpl
		 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccesscontrolPackageImpl#getRoleCharacteristic()
		 * @generated
		 */
		EClass ROLE_CHARACTERISTIC = eINSTANCE.getRoleCharacteristic();

	}

} //AccesscontrolPackage
