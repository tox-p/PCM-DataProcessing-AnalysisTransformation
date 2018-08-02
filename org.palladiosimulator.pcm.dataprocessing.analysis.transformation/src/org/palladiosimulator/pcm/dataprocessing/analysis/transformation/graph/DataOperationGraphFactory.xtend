package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.graph

import java.util.LinkedList
import java.util.List
import java.util.Optional
import org.eclipse.emf.ecore.EObject
import org.jgrapht.graph.DefaultDirectedGraph
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.DataEdge
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation

class DataOperationGraphFactory {
	
	val DataOperation dummyOperation
	
	new(DataOperation dummyOperation) {
		this.dummyOperation = dummyOperation
	}
	
	def createDataOpGraph(Iterable<DataOperation> dataOps) {
 		val graphBuilder = DefaultDirectedGraph.builder(DataEdge)
 		dataOps.forEach[o | graphBuilder.addVertex(o)]
 		graphBuilder.addVertex(dummyOperation)
 		
 		val operationQueue = new LinkedList<DataOperation>()
 		operationQueue.addAll(dataOps.filter[op | op.outgoingData.isEmpty]) // assumption: every data flow is terminated by a consumer
 		while (!operationQueue.isEmpty) {
 			val currentOperation = operationQueue.pop
 			val requirements = currentOperation.incomingData
 			for (requirement : requirements) {
 				var providers = dataOps.filter[dataOp | dataOp.outgoingData.contains(requirement)]
 				val providerPredecessors = providers.filter[incomingData.contains(requirement)].toList
 				providers = providers.filter[p | !providerPredecessors.contains(p)]
 				if (providers.size > 1) {
 					throw new IllegalStateException("There has to be exactly one provider for data instance.")
 				}
 				
 				val sortedPredecessors = providerPredecessors.sortBy[containerIndex].toList
 				val DataOperation provider = if (providers.size == 1)  providers.iterator.next else dummyOperation
 				operationQueue.add(provider)

 				Optional.ofNullable(sortedPredecessors.head).ifPresent(p | graphBuilder.addEdge(provider, p, new DataEdge(requirement)))
 				 for (var i = 1; i < sortedPredecessors.size; i++) {
					graphBuilder.addEdge(sortedPredecessors.get(i - 1), sortedPredecessors.get(i), new DataEdge(requirement)) 					
 				}
 				graphBuilder.addEdge(Optional.ofNullable(sortedPredecessors.last).orElse(provider), currentOperation, new DataEdge(requirement))
 			}
 		}
 		
 		graphBuilder.build
	}
	
	protected static def getContainerIndex(EObject obj) {
		val containerFeature = obj.eContainmentFeature
		if (containerFeature !== null && containerFeature.isMany) {
			val containerList = obj.eContainer.eGet(containerFeature) as List<EObject>
			return containerList.indexOf(obj)
		}
		return 0
	}
}