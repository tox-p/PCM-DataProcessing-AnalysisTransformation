package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.basic.impl

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import de.uka.ipd.sdq.identifier.Identifier
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance
import org.palladiosimulator.pcm.repository.DataType
import com.google.common.collect.ImmutableBiMap

class CachedUniqueNameProvider extends UniqueNameProvider {
	
	val BiMap<Object, String> cache = HashBiMap.create
	
	def lookupObject(String uniqueName) {
		cache.get(uniqueName)
	}
	
	def lookupName(Object object) {
		cache.inverse.get(object)
	}
	
	def getCache() {
		ImmutableBiMap.copyOf(cache)
	}
	
	override String uniqueName(Entity entity) {
		cache.computeIfAbsent(entity, [super.uniqueName(entity)])
	}
	
	override String uniqueName(Identifier entity) {
		cache.computeIfAbsent(entity, [super.uniqueName(entity)])		
	}
	
	override String uniqueName(IdentifierInstance<?, ?> identifierInstance) {
		cache.computeIfAbsent(identifierInstance, [super.uniqueName(identifierInstance)])
	}
	
	override String uniqueName(DataType dataType) {
		val name = super.uniqueName(dataType)
		if (!cache.inverse.containsKey(name)) {
			cache.put(dataType, name);
		}
		name
	}
	
}