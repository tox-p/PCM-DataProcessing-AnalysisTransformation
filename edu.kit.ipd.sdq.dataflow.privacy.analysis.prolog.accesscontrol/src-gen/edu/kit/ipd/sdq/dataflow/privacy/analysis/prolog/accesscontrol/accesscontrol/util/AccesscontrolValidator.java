/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.util;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccesscontrolPackage
 * @generated
 */
public class AccesscontrolValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final AccesscontrolValidator INSTANCE = new AccesscontrolValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccesscontrolValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return AccesscontrolPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case AccesscontrolPackage.ROLE_CHARACTERISTIC:
				return validateRoleCharacteristic((RoleCharacteristic)value, diagnostics, context);
			case AccesscontrolPackage.ACCESS_CONTROL_CHARACTERISTIC:
				return validateAccessControlCharacteristic((AccessControlCharacteristic)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoleCharacteristic(RoleCharacteristic roleCharacteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(roleCharacteristic, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validateRoleCharacteristic_prescribeName(roleCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validateRoleCharacteristic_sameEnumAsAccessControlCharacteristic(roleCharacteristic, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the prescribeName constraint of '<em>Role Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROLE_CHARACTERISTIC__PRESCRIBE_NAME__EEXPRESSION = "name = 'Role'";

	/**
	 * Validates the prescribeName constraint of '<em>Role Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoleCharacteristic_prescribeName(RoleCharacteristic roleCharacteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(AccesscontrolPackage.Literals.ROLE_CHARACTERISTIC,
				 roleCharacteristic,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "prescribeName",
				 ROLE_CHARACTERISTIC__PRESCRIBE_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the sameEnumAsAccessControlCharacteristic constraint of '<em>Role Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROLE_CHARACTERISTIC__SAME_ENUM_AS_ACCESS_CONTROL_CHARACTERISTIC__EEXPRESSION = "\n" +
		"\t\t\tlet otherCharacteristics = AccessControlCharacteristic.allInstances() in\n" +
		"\t\t\t\totherCharacteristics->size() = 0 or (self.enum->includesAll(otherCharacteristics.enum))";

	/**
	 * Validates the sameEnumAsAccessControlCharacteristic constraint of '<em>Role Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoleCharacteristic_sameEnumAsAccessControlCharacteristic(RoleCharacteristic roleCharacteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(AccesscontrolPackage.Literals.ROLE_CHARACTERISTIC,
				 roleCharacteristic,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sameEnumAsAccessControlCharacteristic",
				 ROLE_CHARACTERISTIC__SAME_ENUM_AS_ACCESS_CONTROL_CHARACTERISTIC__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlCharacteristic(AccessControlCharacteristic accessControlCharacteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(accessControlCharacteristic, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validateAccessControlCharacteristic_prescribeName(accessControlCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validateAccessControlCharacteristic_sameEnumAsRoleCharacteristic(accessControlCharacteristic, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the prescribeName constraint of '<em>Access Control Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACCESS_CONTROL_CHARACTERISTIC__PRESCRIBE_NAME__EEXPRESSION = "name = 'AccessRights'";

	/**
	 * Validates the prescribeName constraint of '<em>Access Control Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlCharacteristic_prescribeName(AccessControlCharacteristic accessControlCharacteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(AccesscontrolPackage.Literals.ACCESS_CONTROL_CHARACTERISTIC,
				 accessControlCharacteristic,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "prescribeName",
				 ACCESS_CONTROL_CHARACTERISTIC__PRESCRIBE_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the sameEnumAsRoleCharacteristic constraint of '<em>Access Control Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACCESS_CONTROL_CHARACTERISTIC__SAME_ENUM_AS_ROLE_CHARACTERISTIC__EEXPRESSION = "\n" +
		"\t\t\tlet otherCharacteristics = RoleCharacteristic.allInstances() in\n" +
		"\t\t\t\totherCharacteristics->size() = 0 or (self.enum->includesAll(otherCharacteristics.enum))";

	/**
	 * Validates the sameEnumAsRoleCharacteristic constraint of '<em>Access Control Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlCharacteristic_sameEnumAsRoleCharacteristic(AccessControlCharacteristic accessControlCharacteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(AccesscontrolPackage.Literals.ACCESS_CONTROL_CHARACTERISTIC,
				 accessControlCharacteristic,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sameEnumAsRoleCharacteristic",
				 ACCESS_CONTROL_CHARACTERISTIC__SAME_ENUM_AS_ROLE_CHARACTERISTIC__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //AccesscontrolValidator
