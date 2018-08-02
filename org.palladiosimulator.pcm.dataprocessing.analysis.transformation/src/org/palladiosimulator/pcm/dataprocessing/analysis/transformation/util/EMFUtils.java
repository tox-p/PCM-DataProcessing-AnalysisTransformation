package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.modelversioning.emfprofileapplication.ProfileApplication;
import org.modelversioning.emfprofileapplication.StereotypeApplication;
import org.palladiosimulator.mdsdprofiles.api.ProfileAPI;

public class EMFUtils {

	public static Collection<EObject> getStereotypedElements(String stereotypeName, EObject taggedValue) {
		return taggedValue.eResource().getResourceSet().getResources().stream()
				.filter(ProfileAPI::hasProfileApplication)
				.map(ProfileAPI::getProfileApplication)
				.map(ProfileApplication::getStereotypeApplications)
				.flatMap(Collection::stream)
				.filter(a -> stereotypeName.equals(a.getStereotype().getName()))
				.filter(a -> a.eGet(a.getStereotype().getTaggedValues().iterator().next()) == taggedValue)
				.map(StereotypeApplication::getAppliedTo)
				.collect(Collectors.toList());
	}
	
}
