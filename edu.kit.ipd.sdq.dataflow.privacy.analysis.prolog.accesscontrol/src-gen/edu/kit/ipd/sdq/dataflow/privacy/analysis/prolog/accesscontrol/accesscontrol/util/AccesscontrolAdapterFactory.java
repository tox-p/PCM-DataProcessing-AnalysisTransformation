/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.util;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccesscontrolPackage
 * @generated
 */
public class AccesscontrolAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AccesscontrolPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccesscontrolAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AccesscontrolPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccesscontrolSwitch<Adapter> modelSwitch =
		new AccesscontrolSwitch<Adapter>() {
			@Override
			public Adapter caseRoleCharacteristic(RoleCharacteristic object) {
				return createRoleCharacteristicAdapter();
			}
			@Override
			public Adapter caseAccessControlCharacteristic(AccessControlCharacteristic object) {
				return createAccessControlCharacteristicAdapter();
			}
			@Override
			public Adapter caseIdHavingElement(IdHavingElement object) {
				return createIdHavingElementAdapter();
			}
			@Override
			public Adapter caseNameHavingElement(NameHavingElement object) {
				return createNameHavingElementAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
			}
			@Override
			public Adapter caseCharacteristic(Characteristic object) {
				return createCharacteristicAdapter();
			}
			@Override
			public Adapter caseEnumCharacteristic(EnumCharacteristic object) {
				return createEnumCharacteristicAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccessControlCharacteristic <em>Access Control Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.AccessControlCharacteristic
	 * @generated
	 */
	public Adapter createAccessControlCharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.RoleCharacteristic <em>Role Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.accesscontrol.RoleCharacteristic
	 * @generated
	 */
	public Adapter createRoleCharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement <em>Id Having Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.IdHavingElement
	 * @generated
	 */
	public Adapter createIdHavingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement <em>Name Having Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.NameHavingElement
	 * @generated
	 */
	public Adapter createNameHavingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.Characteristic
	 * @generated
	 */
	public Adapter createCharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic <em>Enum Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.EnumCharacteristic
	 * @generated
	 */
	public Adapter createEnumCharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AccesscontrolAdapterFactory
