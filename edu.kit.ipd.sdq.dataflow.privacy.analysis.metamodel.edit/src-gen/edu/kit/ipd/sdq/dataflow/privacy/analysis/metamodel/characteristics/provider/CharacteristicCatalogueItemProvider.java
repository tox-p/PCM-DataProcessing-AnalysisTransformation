/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.provider;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsFactory;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicsPackage;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.FlowFactory;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.operations.OperationsFactory;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.characteristics.CharacteristicCatalogue} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CharacteristicCatalogueItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicCatalogueItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS);
			childrenFeatures.add(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns CharacteristicCatalogue.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CharacteristicCatalogue"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_CharacteristicCatalogue_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CharacteristicCatalogue.class)) {
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__CHARACTERISTICS:
		case CharacteristicsPackage.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						CharacteristicsFactory.eINSTANCE.createEnum()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						CharacteristicsFactory.eINSTANCE.createEnumLiteral()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						OperationsFactory.eINSTANCE.createEnumCharacteristicChangingOperation()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						OperationsFactory.eINSTANCE.createDataTransformingOperation()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						OperationsFactory.eINSTANCE.createParameterizedDataTransformingOperation()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						FlowFactory.eINSTANCE.createNodeContainer()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						FlowFactory.eINSTANCE.createFlowStart()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						FlowFactory.eINSTANCE.createFlowEnd()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						FlowFactory.eINSTANCE.createFlowNode()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						FlowFactory.eINSTANCE.createFlow()));

		newChildDescriptors
				.add(createChildParameter(CharacteristicsPackage.Literals.CHARACTERISTIC_CATALOGUE__OWNED_ENTITIES,
						FlowFactory.eINSTANCE.createData()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ((IChildCreationExtender) adapterFactory).getResourceLocator();
	}

}
