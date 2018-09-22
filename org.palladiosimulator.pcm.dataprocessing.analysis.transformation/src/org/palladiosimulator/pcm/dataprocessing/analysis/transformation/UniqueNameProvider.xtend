package org.palladiosimulator.pcm.dataprocessing.analysis.transformation

import de.uka.ipd.sdq.identifier.Identifier
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.PCM2DFSystemModelTransformation.DataTypeWrapper
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.repository.PrimitiveDataType
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.Hash
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance

class UniqueNameProvider {
	
	
	def String uniqueName(Entity entity) {
		(entity as Identifier).uniqueName
	}
    
	
	def String uniqueName(Identifier entity) {
		Hash.init(entity.id).hash
	}
	
	def String uniqueName(IdentifierInstance<?, ?> identifierInstance) {
		var identifierId = ""
		if (identifierInstance.identifier.isPresent) {
			identifierId = (identifierInstance.identifier.get as Identifier).id
		}
		Hash.init(identifierId).add(identifierInstance.entity.id).hash
	}
	
	def String uniqueName(DataType dataType) {
		dataType.uniqueNameDataType
	}
	
	protected def dispatch String uniqueNameDataType(PrimitiveDataType dataType)
	'''primitiveDataType_«dataType.type.getName»'''
	
	protected def dispatch String uniqueNameDataType(Entity dataType) {
		dataType.uniqueName
	}
	
	protected def dispatch String uniqueNameDataType(DataTypeWrapper dataType) {
		dataType.delegate.uniqueNameDataType
	}
	
}