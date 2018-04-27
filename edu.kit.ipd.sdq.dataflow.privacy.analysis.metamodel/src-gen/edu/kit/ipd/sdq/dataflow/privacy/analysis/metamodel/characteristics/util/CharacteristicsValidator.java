/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.util;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiteral;

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
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage
 * @generated
 */
public class CharacteristicsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CharacteristicsValidator INSTANCE = new CharacteristicsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics";

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
	public CharacteristicsValidator() {
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
		return CharacteristicsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT:
			return validateCharacteristicsHavingElement((CharacteristicsHavingElement) value, diagnostics, context);
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE:
			return validateCharacteristicCatalogue((CharacteristicCatalogue) value, diagnostics, context);
		case CharacteristicsPackage.CHARACTERISTIC:
			return validateCharacteristic((Characteristic) value, diagnostics, context);
		case CharacteristicsPackage.ENUM_CHARACTERISTIC:
			return validateEnumCharacteristic((EnumCharacteristic) value, diagnostics, context);
		case CharacteristicsPackage.CHARACTERISTIC_VALUE:
			return validateCharacteristicValue((CharacteristicValue<?>) value, diagnostics, context);
		case CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE:
			return validateEnumCharacteristicValue((EnumCharacteristicValue) value, diagnostics, context);
		case CharacteristicsPackage.ENUM:
			return validateEnum((edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum) value,
					diagnostics, context);
		case CharacteristicsPackage.ENUM_LITERAL:
			return validateEnumLiteral((EnumLiteral) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristicsHavingElement(CharacteristicsHavingElement characteristicsHavingElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(characteristicsHavingElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristicCatalogue(CharacteristicCatalogue characteristicCatalogue,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(characteristicCatalogue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristic(Characteristic characteristic, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characteristic, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(characteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCharacteristic_nameHasToBeId(characteristic, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the nameHasToBeId constraint of '<em>Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERISTIC__NAME_HAS_TO_BE_ID__EEXPRESSION = "self.name.matches('[a-zA-Z0-9]+')";

	/**
	 * Validates the nameHasToBeId constraint of '<em>Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristic_nameHasToBeId(Characteristic characteristic, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(CharacteristicsPackage.Literals.CHARACTERISTIC, characteristic, diagnostics, context,
				"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "nameHasToBeId",
				CHARACTERISTIC__NAME_HAS_TO_BE_ID__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumCharacteristic(EnumCharacteristic enumCharacteristic, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumCharacteristic, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCharacteristic_nameHasToBeId(enumCharacteristic, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristicValue(CharacteristicValue<?> characteristicValue, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(characteristicValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumCharacteristicValue(EnumCharacteristicValue enumCharacteristicValue,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumCharacteristicValue, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(enumCharacteristicValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateEnumCharacteristicValue_onlyLiteralsFromMatchingEnum(enumCharacteristicValue, diagnostics,
					context);
		return result;
	}

	/**
	 * The cached validation expression for the onlyLiteralsFromMatchingEnum constraint of '<em>Enum Characteristic Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENUM_CHARACTERISTIC_VALUE__ONLY_LITERALS_FROM_MATCHING_ENUM__EEXPRESSION = "characteristic.oclAsType(EnumCharacteristic).enum.literals->includesAll(enumliterals)";

	/**
	 * Validates the onlyLiteralsFromMatchingEnum constraint of '<em>Enum Characteristic Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumCharacteristicValue_onlyLiteralsFromMatchingEnum(
			EnumCharacteristicValue enumCharacteristicValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(CharacteristicsPackage.Literals.ENUM_CHARACTERISTIC_VALUE, enumCharacteristicValue, diagnostics,
				context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "onlyLiteralsFromMatchingEnum",
				ENUM_CHARACTERISTIC_VALUE__ONLY_LITERALS_FROM_MATCHING_ENUM__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnum(edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum enum_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enum_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteral(EnumLiteral enumLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumLiteral, diagnostics, context);
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

} //CharacteristicsValidator
