/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.impl;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccesscontrolFactoryImpl extends EFactoryImpl implements AccesscontrolFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AccesscontrolFactory init() {
		try {
			AccesscontrolFactory theAccesscontrolFactory = (AccesscontrolFactory)EPackage.Registry.INSTANCE.getEFactory(AccesscontrolPackage.eNS_URI);
			if (theAccesscontrolFactory != null) {
				return theAccesscontrolFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AccesscontrolFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccesscontrolFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AccesscontrolPackage.ROLE_CHARACTERISTIC: return createRoleCharacteristic();
			case AccesscontrolPackage.ACCESS_CONTROL_CHARACTERISTIC: return createAccessControlCharacteristic();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlCharacteristic createAccessControlCharacteristic() {
		AccessControlCharacteristicImpl accessControlCharacteristic = new AccessControlCharacteristicImpl();
		return accessControlCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleCharacteristic createRoleCharacteristic() {
		RoleCharacteristicImpl roleCharacteristic = new RoleCharacteristicImpl();
		return roleCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccesscontrolPackage getAccesscontrolPackage() {
		return (AccesscontrolPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AccesscontrolPackage getPackage() {
		return AccesscontrolPackage.eINSTANCE;
	}

} //AccesscontrolFactoryImpl
