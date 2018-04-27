/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccesscontrolPackage
 * @generated
 */
public interface AccesscontrolFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AccesscontrolFactory eINSTANCE = edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl.AccesscontrolFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Access Control Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Control Characteristic</em>'.
	 * @generated
	 */
	AccessControlCharacteristic createAccessControlCharacteristic();

	/**
	 * Returns a new object of class '<em>Role Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Characteristic</em>'.
	 * @generated
	 */
	RoleCharacteristic createRoleCharacteristic();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AccesscontrolPackage getAccesscontrolPackage();

} //AccesscontrolFactory
