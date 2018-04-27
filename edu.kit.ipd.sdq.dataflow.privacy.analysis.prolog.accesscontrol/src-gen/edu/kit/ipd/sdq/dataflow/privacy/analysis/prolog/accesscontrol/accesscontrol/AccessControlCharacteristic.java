/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Control Characteristic</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccesscontrolPackage#getAccessControlCharacteristic()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='prescribeName sameEnumAsRoleCharacteristic'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot prescribeName='name = \'AccessRights\'' sameEnumAsRoleCharacteristic='\n\t\t\tlet otherCharacteristics = RoleCharacteristic.allInstances() in\n\t\t\t\totherCharacteristics-&gt;size() = 0 or (self.enum-&gt;includesAll(otherCharacteristics.enum))'"
 * @generated
 */
public interface AccessControlCharacteristic extends EnumCharacteristic {
} // AccessControlCharacteristic
