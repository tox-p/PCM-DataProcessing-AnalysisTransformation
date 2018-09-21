package org.palladiosimulator.pcm.dataprocessing.analysis.transformation

import de.uka.ipd.sdq.identifier.Identifier
import org.palladiosimulator.pcm.core.entity.Entity
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.PCM2DFSystemModelTransformation.DataTypeWrapper
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.repository.PrimitiveDataType

class UniqueNameProvider {
	
	def String uniqueName(Entity entity)
	'''«entity.entityName»_(«entity.id»)'''
	
	def String uniqueName(Identifier entity)
	'''«entity.class.name»_«entity.id»'''
	
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