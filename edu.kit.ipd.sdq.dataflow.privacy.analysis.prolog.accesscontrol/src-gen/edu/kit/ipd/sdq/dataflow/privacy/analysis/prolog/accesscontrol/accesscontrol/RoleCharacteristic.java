/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Characteristic</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccesscontrolPackage#getRoleCharacteristic()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='prescribeName sameEnumAsAccessControlCharacteristic'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot prescribeName='name = \'Role\'' sameEnumAsAccessControlCharacteristic='\n\t\t\tlet otherCharacteristics = AccessControlCharacteristic.allInstances() in\n\t\t\t\totherCharacteristics-&gt;size() = 0 or (self.enum-&gt;includesAll(otherCharacteristics.enum))'"
 * @generated
 */
public interface RoleCharacteristic extends EnumCharacteristic {
} // RoleCharacteristic
