/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage
 * @generated
 */
public interface CharacteristicsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CharacteristicsFactory eINSTANCE = edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.impl.CharacteristicsFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Characteristic Catalogue</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characteristic Catalogue</em>'.
	 * @generated
	 */
	CharacteristicCatalogue createCharacteristicCatalogue();

	/**
	 * Returns a new object of class '<em>Enum Characteristic Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Characteristic Value</em>'.
	 * @generated
	 */
	EnumCharacteristicValue createEnumCharacteristicValue();

	/**
	 * Returns a new object of class '<em>Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum</em>'.
	 * @generated
	 */
	Enum createEnum();

	/**
	 * Returns a new object of class '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal</em>'.
	 * @generated
	 */
	EnumLiteral createEnumLiteral();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CharacteristicsPackage getCharacteristicsPackage();

} //CharacteristicsFactory
