/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.util;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsHavingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristicValue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumLiteral;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage
 * @generated
 */
public class CharacteristicsSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CharacteristicsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicsSwitch() {
		if (modelPackage == null) {
			modelPackage = CharacteristicsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case CharacteristicsPackage.CHARACTERISTICS_HAVING_ELEMENT: {
			CharacteristicsHavingElement characteristicsHavingElement = (CharacteristicsHavingElement) theEObject;
			T1 result = caseCharacteristicsHavingElement(characteristicsHavingElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE: {
			CharacteristicCatalogue characteristicCatalogue = (CharacteristicCatalogue) theEObject;
			T1 result = caseCharacteristicCatalogue(characteristicCatalogue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CharacteristicsPackage.CHARACTERISTIC: {
			Characteristic characteristic = (Characteristic) theEObject;
			T1 result = caseCharacteristic(characteristic);
			if (result == null)
				result = caseEntity(characteristic);
			if (result == null)
				result = caseIdHavingElement(characteristic);
			if (result == null)
				result = caseNameHavingElement(characteristic);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CharacteristicsPackage.ENUM_CHARACTERISTIC: {
			EnumCharacteristic enumCharacteristic = (EnumCharacteristic) theEObject;
			T1 result = caseEnumCharacteristic(enumCharacteristic);
			if (result == null)
				result = caseCharacteristic(enumCharacteristic);
			if (result == null)
				result = caseEntity(enumCharacteristic);
			if (result == null)
				result = caseIdHavingElement(enumCharacteristic);
			if (result == null)
				result = caseNameHavingElement(enumCharacteristic);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CharacteristicsPackage.CHARACTERISTIC_VALUE: {
			CharacteristicValue<?> characteristicValue = (CharacteristicValue<?>) theEObject;
			T1 result = caseCharacteristicValue(characteristicValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CharacteristicsPackage.ENUM_CHARACTERISTIC_VALUE: {
			EnumCharacteristicValue enumCharacteristicValue = (EnumCharacteristicValue) theEObject;
			T1 result = caseEnumCharacteristicValue(enumCharacteristicValue);
			if (result == null)
				result = caseCharacteristicValue(enumCharacteristicValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CharacteristicsPackage.ENUM: {
			edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum enum_ = (edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum) theEObject;
			T1 result = caseEnum(enum_);
			if (result == null)
				result = caseEntity(enum_);
			if (result == null)
				result = caseIdHavingElement(enum_);
			if (result == null)
				result = caseNameHavingElement(enum_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CharacteristicsPackage.ENUM_LITERAL: {
			EnumLiteral enumLiteral = (EnumLiteral) theEObject;
			T1 result = caseEnumLiteral(enumLiteral);
			if (result == null)
				result = caseEntity(enumLiteral);
			if (result == null)
				result = caseIdHavingElement(enumLiteral);
			if (result == null)
				result = caseNameHavingElement(enumLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Having Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Having Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCharacteristicsHavingElement(CharacteristicsHavingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characteristic Catalogue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characteristic Catalogue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCharacteristicCatalogue(CharacteristicCatalogue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characteristic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCharacteristic(Characteristic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Characteristic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumCharacteristic(EnumCharacteristic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characteristic Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characteristic Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Characteristic> T1 caseCharacteristicValue(CharacteristicValue<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Characteristic Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Characteristic Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumCharacteristicValue(EnumCharacteristicValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnum(edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Enum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumLiteral(EnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Having Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Having Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdHavingElement(IdHavingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Having Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Having Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNameHavingElement(NameHavingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //CharacteristicsSwitch
