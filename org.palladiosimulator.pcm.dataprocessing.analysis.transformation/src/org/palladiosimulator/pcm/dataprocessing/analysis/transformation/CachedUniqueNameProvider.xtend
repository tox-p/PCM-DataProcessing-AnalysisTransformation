package org.palladiosimulator.pcm.dataprocessing.analysis.transformation

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import de.uka.ipd.sdq.identifier.Identifier
import org.eclipse.emf.ecore.EObject
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.repository.DataType

class CachedUniqueNameProvider extends UniqueNameProvider {
	
	val BiMap<EObject, String> cache = HashBiMap.create
	
	def lookupObject(String uniqueName) {
		cache.get(uniqueName)
	}
	
	def lookupName(EObject object) {
		cache.inverse.get(object)
	}
	
	override String uniqueName(Entity entity) {
		cache.computeIfAbsent(entity, [super.uniqueName(entity)])
	}
	
	override String uniqueName(Identifier entity) {
		cache.computeIfAbsent(entity, [super.uniqueName(entity)])		
	}
	
	override String uniqueName(DataType dataType) {
		val name = super.uniqueName(dataType)
		if (!cache.inverse.containsKey(name)) {
			cache.put(dataType, name);
		}
		name
	}
	
}