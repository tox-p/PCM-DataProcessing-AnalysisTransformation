package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.modelversioning.emfprofileapplication.ProfileApplication;
import org.modelversioning.emfprofileapplication.StereotypeApplication;
import org.palladiosimulator.mdsdprofiles.api.ProfileAPI;
import org.palladiosimulator.mdsdprofiles.api.StereotypeAPI;

public class EMFUtils {

	public static Collection<EObject> getStereotypedElements(String stereotypeName, EObject taggedValue) {
		return taggedValue.eResource().getResourceSet().getResources().stream()
				.filter(ProfileAPI::hasProfileApplication).map(ProfileAPI::getProfileApplication)
				.map(ProfileApplication::getStereotypeApplications).flatMap(Collection::stream)
				.filter(a -> stereotypeName.equals(a.getStereotype().getName()))
				.filter(a -> a.eGet(a.getStereotype().getTaggedValues().iterator().next()) == taggedValue)
				.map(StereotypeApplication::getAppliedTo).collect(Collectors.toList());
	}

	public static <T extends EObject> Collection<T> getStereotypedElements(String stereotypeName, EObject taggedValue,
			Class<T> wantedType) {
		return getStereotypedElements(stereotypeName, taggedValue).stream().filter(wantedType::isInstance)
				.map(wantedType::cast).collect(Collectors.toList());
	}

	public static <T extends EObject> T getTaggedValue(final EObject stereotypedElement, final String taggedValueName,
			final String stereotypeName, Class<T> clz) {
		return Optional.ofNullable(StereotypeAPI.getTaggedValue(stereotypedElement, taggedValueName, stereotypeName))
				.filter(clz::isInstance).map(clz::cast).orElseThrow(() -> new NoSuchElementException());
	}

	public static <T extends EObject> Optional<T> getParentOfType(EObject input, Class<T> parentType) {
		EObject currentObject = input;
		while (currentObject != null && !parentType.isInstance(currentObject)) {
			currentObject = currentObject.eContainer();
		}
		return Optional.ofNullable(currentObject).map(parentType::cast);
	}

}
