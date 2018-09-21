package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.graph;

import com.google.common.collect.Iterables;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.builder.GraphBuilder;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.DataEdge;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation;

@SuppressWarnings("all")
public class DataOperationGraphFactory {
  private final DataOperation dummyOperation;
  
  public DataOperationGraphFactory(final DataOperation dummyOperation) {
    this.dummyOperation = dummyOperation;
  }
  
  public DefaultDirectedGraph<DataOperation, DataEdge> createDataOpGraph(final Iterable<DataOperation> dataOps) {
    DefaultDirectedGraph<DataOperation, DataEdge> _xblockexpression = null;
    {
      final GraphBuilder<DataOperation, DataEdge, ? extends DefaultDirectedGraph<DataOperation, DataEdge>> graphBuilder = DefaultDirectedGraph.<DataOperation, DataEdge>createBuilder(DataEdge.class);
      final Consumer<DataOperation> _function = (DataOperation o) -> {
        graphBuilder.addVertex(o);
      };
      dataOps.forEach(_function);
      graphBuilder.addVertex(this.dummyOperation);
      final LinkedList<DataOperation> operationQueue = new LinkedList<DataOperation>();
      final Function1<DataOperation, Boolean> _function_1 = (DataOperation op) -> {
        return Boolean.valueOf(op.getOutgoingData().isEmpty());
      };
      Iterables.<DataOperation>addAll(operationQueue, IterableExtensions.<DataOperation>filter(dataOps, _function_1));
      while ((!operationQueue.isEmpty())) {
        {
          final DataOperation currentOperation = operationQueue.pop();
          final EList<Data> requirements = currentOperation.getIncomingData();
          for (final Data requirement : requirements) {
            {
              final Function1<DataOperation, Boolean> _function_2 = (DataOperation dataOp) -> {
                return Boolean.valueOf(dataOp.getOutgoingData().contains(requirement));
              };
              Iterable<DataOperation> providers = IterableExtensions.<DataOperation>filter(dataOps, _function_2);
              final Function1<DataOperation, Boolean> _function_3 = (DataOperation it) -> {
                return Boolean.valueOf(it.getIncomingData().contains(requirement));
              };
              final List<DataOperation> providerPredecessors = IterableExtensions.<DataOperation>toList(IterableExtensions.<DataOperation>filter(providers, _function_3));
              final Function1<DataOperation, Boolean> _function_4 = (DataOperation p) -> {
                boolean _contains = providerPredecessors.contains(p);
                return Boolean.valueOf((!_contains));
              };
              providers = IterableExtensions.<DataOperation>filter(providers, _function_4);
              int _size = IterableExtensions.size(providers);
              boolean _greaterThan = (_size > 1);
              if (_greaterThan) {
                throw new IllegalStateException("There has to be exactly one provider for data instance.");
              }
              final Function1<DataOperation, Integer> _function_5 = (DataOperation it) -> {
                return Integer.valueOf(DataOperationGraphFactory.getContainerIndex(it));
              };
              final List<DataOperation> sortedPredecessors = IterableExtensions.<DataOperation>toList(IterableExtensions.<DataOperation, Integer>sortBy(providerPredecessors, _function_5));
              DataOperation _xifexpression = null;
              int _size_1 = IterableExtensions.size(providers);
              boolean _equals = (_size_1 == 1);
              if (_equals) {
                _xifexpression = providers.iterator().next();
              } else {
                _xifexpression = this.dummyOperation;
              }
              final DataOperation provider = _xifexpression;
              operationQueue.add(provider);
              final Consumer<DataOperation> _function_6 = (DataOperation p) -> {
                DataEdge _dataEdge = new DataEdge(requirement);
                graphBuilder.addEdge(provider, p, _dataEdge);
              };
              Optional.<DataOperation>ofNullable(IterableExtensions.<DataOperation>head(sortedPredecessors)).ifPresent(_function_6);
              for (int i = 1; (i < sortedPredecessors.size()); i++) {
                DataOperation _get = sortedPredecessors.get((i - 1));
                DataOperation _get_1 = sortedPredecessors.get(i);
                DataEdge _dataEdge = new DataEdge(requirement);
                graphBuilder.addEdge(_get, _get_1, _dataEdge);
              }
              DataOperation _orElse = Optional.<DataOperation>ofNullable(IterableExtensions.<DataOperation>last(sortedPredecessors)).orElse(provider);
              DataEdge _dataEdge = new DataEdge(requirement);
              graphBuilder.addEdge(_orElse, currentOperation, _dataEdge);
            }
          }
        }
      }
      _xblockexpression = graphBuilder.build();
    }
    return _xblockexpression;
  }
  
  protected static int getContainerIndex(final EObject obj) {
    final EReference containerFeature = obj.eContainmentFeature();
    if (((containerFeature != null) && containerFeature.isMany())) {
      Object _eGet = obj.eContainer().eGet(containerFeature);
      final List<EObject> containerList = ((List<EObject>) _eGet);
      return containerList.indexOf(obj);
    }
    return 0;
  }
}
