package org.palladiosimulator.pcm.dataprocessing.analysis.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.uka.ipd.sdq.identifier.Identifier;
import edu.kit.ipd.sdq.dataflow.systemmodel.Caller;
import edu.kit.ipd.sdq.dataflow.systemmodel.LogicTerm;
import edu.kit.ipd.sdq.dataflow.systemmodel.Operation;
import edu.kit.ipd.sdq.dataflow.systemmodel.OperationCall;
import edu.kit.ipd.sdq.dataflow.systemmodel.ReturnValueRef;
import edu.kit.ipd.sdq.dataflow.systemmodel.StateRef;
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemModelFactory;
import edu.kit.ipd.sdq.dataflow.systemmodel.SystemUsage;
import edu.kit.ipd.sdq.dataflow.systemmodel.Value;
import edu.kit.ipd.sdq.dataflow.systemmodel.ValueSetType;
import edu.kit.ipd.sdq.dataflow.systemmodel.Variable;
import edu.kit.ipd.sdq.dataflow.systemmodel.VariableAssignment;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectHistory;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.lock.CDOLockState;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.security.CDOPermission;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.palladiosimulator.mdsdprofiles.api.StereotypeAPI;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.PCM2IntermediateModelTransformator;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.DataEdge;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.IdentifierInstance;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto.SEFFInstance;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.graph.DataOperationGraphFactory;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.EMFUtils;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.Hash;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicType;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.CharacteristicTypeContainer;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicLiteral;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.characteristics.EnumCharacteristicType;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.ParameterBasedData;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataOperation;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.DataProcessingContainer;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.PerformDataTransmissionOperation;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ProcessingFactory;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.processing.ReturnDataOperation;
import org.palladiosimulator.pcm.dataprocessing.dataprocessing.seff.DataSEFFSpecification;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.PrimitiveDataType;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

@SuppressWarnings("all")
public class PCM2DFSystemModelTransformation implements PCM2IntermediateModelTransformator {
  private enum VariablePurpose {
    PARAMETER,
    
    STATE,
    
    RETURN;
  }
  
  @Data
  protected static class DataTypeWrapper implements DataType {
    @Delegate
    private final DataType delegate;
    
    public DataTypeWrapper(final DataType type) {
      this.delegate = type;
    }
    
    @Override
    public int hashCode() {
      return PCM2DFSystemModelTransformation.uniqueName(this.delegate).hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
      return ((o instanceof DataType) && (o.hashCode() == this.hashCode()));
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("delegate", this.delegate);
      return b.toString();
    }
    
    @Pure
    public DataType getDelegate() {
      return this.delegate;
    }
    
    public Repository getRepository__DataType() {
      return this.delegate.getRepository__DataType();
    }
    
    public void setRepository__DataType(final Repository value) {
      this.delegate.setRepository__DataType(value);
    }
    
    public boolean cdoConflict() {
      return this.delegate.cdoConflict();
    }
    
    public CDOResource cdoDirectResource() {
      return this.delegate.cdoDirectResource();
    }
    
    public CDOObjectHistory cdoHistory() {
      return this.delegate.cdoHistory();
    }
    
    public CDOID cdoID() {
      return this.delegate.cdoID();
    }
    
    public boolean cdoInvalid() {
      return this.delegate.cdoInvalid();
    }
    
    public CDOLockState cdoLockState() {
      return this.delegate.cdoLockState();
    }
    
    public CDOPermission cdoPermission() {
      return this.delegate.cdoPermission();
    }
    
    public void cdoPrefetch(final int depth) {
      this.delegate.cdoPrefetch(depth);
    }
    
    public CDOLock cdoReadLock() {
      return this.delegate.cdoReadLock();
    }
    
    public void cdoReload() {
      this.delegate.cdoReload();
    }
    
    public CDOResource cdoResource() {
      return this.delegate.cdoResource();
    }
    
    public CDORevision cdoRevision() {
      return this.delegate.cdoRevision();
    }
    
    public CDORevision cdoRevision(final boolean loadOnDemand) {
      return this.delegate.cdoRevision(loadOnDemand);
    }
    
    public CDOState cdoState() {
      return this.delegate.cdoState();
    }
    
    public CDOView cdoView() {
      return this.delegate.cdoView();
    }
    
    public CDOLock cdoWriteLock() {
      return this.delegate.cdoWriteLock();
    }
    
    public CDOLock cdoWriteOption() {
      return this.delegate.cdoWriteOption();
    }
    
    public TreeIterator<EObject> eAllContents() {
      return this.delegate.eAllContents();
    }
    
    public EClass eClass() {
      return this.delegate.eClass();
    }
    
    public EObject eContainer() {
      return this.delegate.eContainer();
    }
    
    public EStructuralFeature eContainingFeature() {
      return this.delegate.eContainingFeature();
    }
    
    public EReference eContainmentFeature() {
      return this.delegate.eContainmentFeature();
    }
    
    public EList<EObject> eContents() {
      return this.delegate.eContents();
    }
    
    public EList<EObject> eCrossReferences() {
      return this.delegate.eCrossReferences();
    }
    
    public Object eGet(final EStructuralFeature feature) {
      return this.delegate.eGet(feature);
    }
    
    public Object eGet(final EStructuralFeature feature, final boolean resolve) {
      return this.delegate.eGet(feature, resolve);
    }
    
    public Object eInvoke(final EOperation operation, final EList<?> arguments) throws InvocationTargetException {
      return this.delegate.eInvoke(operation, arguments);
    }
    
    public boolean eIsProxy() {
      return this.delegate.eIsProxy();
    }
    
    public boolean eIsSet(final EStructuralFeature feature) {
      return this.delegate.eIsSet(feature);
    }
    
    public Resource eResource() {
      return this.delegate.eResource();
    }
    
    public void eSet(final EStructuralFeature feature, final Object newValue) {
      this.delegate.eSet(feature, newValue);
    }
    
    public void eUnset(final EStructuralFeature feature) {
      this.delegate.eUnset(feature);
    }
    
    public EList<Adapter> eAdapters() {
      return this.delegate.eAdapters();
    }
    
    public boolean eDeliver() {
      return this.delegate.eDeliver();
    }
    
    public void eNotify(final Notification notification) {
      this.delegate.eNotify(notification);
    }
    
    public void eSetDeliver(final boolean deliver) {
      this.delegate.eSetDeliver(deliver);
    }
  }
  
  private final static DataOperation SEFF_DUMMY_OPERATION = ProcessingFactory.eINSTANCE.createStoreDataOperation();
  
  private final static SystemModelFactory factory = SystemModelFactory.eINSTANCE;
  
  @Override
  public edu.kit.ipd.sdq.dataflow.systemmodel.System transform(final UsageModel pcmUsageModel, final org.palladiosimulator.pcm.system.System pcmSystem, final Allocation pcmAllocationModel, final CharacteristicTypeContainer pcmCharacteristicTypeContainer) {
    edu.kit.ipd.sdq.dataflow.systemmodel.System _xblockexpression = null;
    {
      edu.kit.ipd.sdq.dataflow.systemmodel.System _system = this.getSystem();
      _system.setName(pcmSystem.getEntityName());
      EList<ValueSetType> _types = this.getSystem().getTypes();
      final Function1<CharacteristicType, ValueSetType> _function = (CharacteristicType it) -> {
        return this.getValueType(it);
      };
      List<ValueSetType> _map = ListExtensions.<CharacteristicType, ValueSetType>map(pcmCharacteristicTypeContainer.getCharacteristicTypes(), _function);
      Iterables.<ValueSetType>addAll(_types, _map);
      EList<Operation> _operations = this.getSystem().getOperations();
      final Function1<SEFFInstance, Operation> _function_1 = (SEFFInstance it) -> {
        return this.getSEFFOperation(it);
      };
      Iterable<Operation> _map_1 = IterableExtensions.<SEFFInstance, Operation>map(this.findAllSEFFs(pcmSystem), _function_1);
      Iterables.<Operation>addAll(_operations, _map_1);
      EList<SystemUsage> _systemusages = this.getSystem().getSystemusages();
      final Function1<UsageScenario, ScenarioBehaviour> _function_2 = (UsageScenario it) -> {
        return it.getScenarioBehaviour_UsageScenario();
      };
      final Function1<ScenarioBehaviour, SystemUsage> _function_3 = (ScenarioBehaviour it) -> {
        return this.getSystemUsage(it);
      };
      List<SystemUsage> _map_2 = ListExtensions.<ScenarioBehaviour, SystemUsage>map(ListExtensions.<UsageScenario, ScenarioBehaviour>map(pcmUsageModel.getUsageScenario_UsageModel(), _function_2), _function_3);
      Iterables.<SystemUsage>addAll(_systemusages, _map_2);
      _xblockexpression = this.getSystem();
    }
    return _xblockexpression;
  }
  
  protected edu.kit.ipd.sdq.dataflow.systemmodel.System getSystem() {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList();
    final edu.kit.ipd.sdq.dataflow.systemmodel.System _result;
    synchronized (_createCache_getSystem) {
      if (_createCache_getSystem.containsKey(_cacheKey)) {
        return _createCache_getSystem.get(_cacheKey);
      }
      edu.kit.ipd.sdq.dataflow.systemmodel.System _createSystem = PCM2DFSystemModelTransformation.factory.createSystem();
      _result = _createSystem;
      _createCache_getSystem.put(_cacheKey, _result);
    }
    _init_getSystem(_result);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, edu.kit.ipd.sdq.dataflow.systemmodel.System> _createCache_getSystem = CollectionLiterals.newHashMap();
  
  private void _init_getSystem(final edu.kit.ipd.sdq.dataflow.systemmodel.System sys) {
  }
  
  protected ValueSetType getValueType(final CharacteristicType characteristicType) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(characteristicType);
    final ValueSetType _result;
    synchronized (_createCache_getValueType) {
      if (_createCache_getValueType.containsKey(_cacheKey)) {
        return _createCache_getValueType.get(_cacheKey);
      }
      ValueSetType _transformCharacteristicType = this.transformCharacteristicType(characteristicType);
      _result = _transformCharacteristicType;
      _createCache_getValueType.put(_cacheKey, _result);
    }
    _init_getValueType(_result, characteristicType);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, ValueSetType> _createCache_getValueType = CollectionLiterals.newHashMap();
  
  private void _init_getValueType(final ValueSetType ct, final CharacteristicType characteristicType) {
  }
  
  protected ValueSetType _transformCharacteristicType(final EnumCharacteristicType characteristic) {
    ValueSetType _xblockexpression = null;
    {
      final ValueSetType valueSetType = PCM2DFSystemModelTransformation.factory.createValueSetType();
      valueSetType.setName(PCM2DFSystemModelTransformation.uniqueName(characteristic));
      EList<Value> _values = valueSetType.getValues();
      final Function1<EnumCharacteristicLiteral, Value> _function = (EnumCharacteristicLiteral it) -> {
        return this.getValue(it);
      };
      List<Value> _map = ListExtensions.<EnumCharacteristicLiteral, Value>map(characteristic.getEnum().getLiterals(), _function);
      Iterables.<Value>addAll(_values, _map);
      _xblockexpression = valueSetType;
    }
    return _xblockexpression;
  }
  
  protected ValueSetType _transformCharacteristicType(final CharacteristicType characteristic) {
    String _name = characteristic.getClass().getName();
    String _plus = ("Unable to transform characteristic " + _name);
    throw new IllegalArgumentException(_plus);
  }
  
  protected Value getValue(final EnumCharacteristicLiteral literal) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(literal);
    final Value _result;
    synchronized (_createCache_getValue) {
      if (_createCache_getValue.containsKey(_cacheKey)) {
        return _createCache_getValue.get(_cacheKey);
      }
      Value _createValue = PCM2DFSystemModelTransformation.factory.createValue();
      _result = _createValue;
      _createCache_getValue.put(_cacheKey, _result);
    }
    _init_getValue(_result, literal);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Value> _createCache_getValue = CollectionLiterals.newHashMap();
  
  private void _init_getValue(final Value value, final EnumCharacteristicLiteral literal) {
    value.setName(PCM2DFSystemModelTransformation.uniqueName(literal));
  }
  
  protected SystemUsage getSystemUsage(final ScenarioBehaviour scenarioBehavior) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(scenarioBehavior);
    final SystemUsage _result;
    synchronized (_createCache_getSystemUsage) {
      if (_createCache_getSystemUsage.containsKey(_cacheKey)) {
        return _createCache_getSystemUsage.get(_cacheKey);
      }
      SystemUsage _createSystemUsage = PCM2DFSystemModelTransformation.factory.createSystemUsage();
      _result = _createSystemUsage;
      _createCache_getSystemUsage.put(_cacheKey, _result);
    }
    _init_getSystemUsage(_result, scenarioBehavior);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, SystemUsage> _createCache_getSystemUsage = CollectionLiterals.newHashMap();
  
  private void _init_getSystemUsage(final SystemUsage sysUsage, final ScenarioBehaviour scenarioBehavior) {
    sysUsage.setName(PCM2DFSystemModelTransformation.uniqueName(scenarioBehavior));
    final Iterable<DataOperation> dataOps = this.findAllDataOperations(scenarioBehavior);
    final Function1<DataOperation, IdentifierInstance<DataOperation, Entity>> _function = (DataOperation it) -> {
      return this.createInstance(it);
    };
    final Function1<IdentifierInstance<DataOperation, Entity>, Operation> _function_1 = (IdentifierInstance<DataOperation, Entity> it) -> {
      return this.getOperation(it);
    };
    final Iterable<Operation> ops = IterableExtensions.<IdentifierInstance<DataOperation, Entity>, Operation>map(IterableExtensions.<DataOperation, IdentifierInstance<DataOperation, Entity>>map(dataOps, _function), _function_1);
    EList<Operation> _operations = this.getSystem().getOperations();
    Iterables.<Operation>addAll(_operations, ops);
    final DefaultDirectedGraph<DataOperation, DataEdge> dataOpGraph = this.createDataOpGraph(dataOps);
    int _size = dataOpGraph.outgoingEdgesOf(PCM2DFSystemModelTransformation.SEFF_DUMMY_OPERATION).size();
    boolean _notEquals = (_size != 0);
    if (_notEquals) {
      throw new IllegalStateException("A usage model cannot provide any data.");
    }
    final HashMap<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, ReturnValueRef> resultRefCache = new HashMap<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, ReturnValueRef>();
    for (final DataOperation dataOp : dataOps) {
      {
        final IdentifierInstance<DataOperation, Entity> callerInstance = this.createInstance(dataOp);
        final Operation caller = this.getOperation(callerInstance);
        final Set<DataEdge> incomingEdges = dataOpGraph.incomingEdgesOf(dataOp);
        for (final DataEdge incomingEdge : incomingEdges) {
          {
            final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data incomingData = incomingEdge.getData();
            LogicTerm incomingDataRef = null;
            final IdentifierInstance<DataOperation, Entity> calleeInstance = this.createInstance(incomingEdge.findSource());
            final Operation callee = this.getOperation(calleeInstance);
            final OperationCall call = this.getOperationCall(caller, callee);
            final Variable calleeVariable = this.getReturnVariable(incomingData, calleeInstance);
            final ReturnValueRef resultRef = PCM2DFSystemModelTransformation.factory.createReturnValueRef();
            resultRef.setCall(call);
            resultRef.setReturnValue(calleeVariable);
            incomingDataRef = resultRef;
            ReturnValueRef _put = resultRefCache.put(incomingData, resultRef);
            boolean _tripleNotEquals = (_put != null);
            if (_tripleNotEquals) {
              throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.");
            }
            EList<VariableAssignment> _returnValueAssignments = caller.getReturnValueAssignments();
            List<VariableAssignment> _createReturnValueAssignments = this.createReturnValueAssignments(callerInstance, incomingData, incomingDataRef);
            Iterables.<VariableAssignment>addAll(_returnValueAssignments, _createReturnValueAssignments);
          }
        }
      }
    }
    final Function1<DataOperation, Boolean> _function_2 = (DataOperation dataOp_1) -> {
      return Boolean.valueOf((!Objects.equal(dataOp_1, PCM2DFSystemModelTransformation.SEFF_DUMMY_OPERATION)));
    };
    final Function1<DataOperation, Boolean> _function_3 = (DataOperation v) -> {
      return Boolean.valueOf(dataOpGraph.outgoingEdgesOf(v).isEmpty());
    };
    final Iterable<DataOperation> consumerOps = IterableExtensions.<DataOperation>filter(IterableExtensions.<DataOperation>filter(dataOpGraph.vertexSet(), _function_2), _function_3);
    EList<OperationCall> _calls = sysUsage.getCalls();
    final Function1<DataOperation, Operation> _function_4 = (DataOperation consumerOp) -> {
      return this.getOperation(this.createInstance(consumerOp));
    };
    final Function1<Operation, OperationCall> _function_5 = (Operation consumerOp) -> {
      return this.getOperationCall(sysUsage, consumerOp);
    };
    Iterable<OperationCall> _map = IterableExtensions.<Operation, OperationCall>map(IterableExtensions.<DataOperation, Operation>map(consumerOps, _function_4), _function_5);
    Iterables.<OperationCall>addAll(_calls, _map);
  }
  
  protected IdentifierInstance<DataOperation, Entity> createInstance(final DataOperation dataOp) {
    return new IdentifierInstance<DataOperation, Entity>(dataOp, null);
  }
  
  protected Operation getSEFFOperation(final SEFFInstance seffInstance) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(seffInstance);
    final Operation _result;
    synchronized (_createCache_getSEFFOperation) {
      if (_createCache_getSEFFOperation.containsKey(_cacheKey)) {
        return _createCache_getSEFFOperation.get(_cacheKey);
      }
      Operation _createOperation = PCM2DFSystemModelTransformation.factory.createOperation();
      _result = _createOperation;
      _createCache_getSEFFOperation.put(_cacheKey, _result);
    }
    _init_getSEFFOperation(_result, seffInstance);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Operation> _createCache_getSEFFOperation = CollectionLiterals.newHashMap();
  
  private void _init_getSEFFOperation(final Operation op, final SEFFInstance seffInstance) {
    op.setName(seffInstance.getUniqueName());
    final Iterable<DataOperation> dataOps = this.findAllDataOperations(seffInstance.getEntity());
    final List<ParameterBasedData> inputParameters = PCM2DFSystemModelTransformation.getParameterBasedData(seffInstance.getEntity());
    EList<Variable> _stateVariables = op.getStateVariables();
    final Function1<ParameterBasedData, Variable> _function = (ParameterBasedData it) -> {
      return this.getStateVariable(it, seffInstance);
    };
    List<Variable> _map = ListExtensions.<ParameterBasedData, Variable>map(inputParameters, _function);
    Iterables.<Variable>addAll(_stateVariables, _map);
    final DefaultDirectedGraph<DataOperation, DataEdge> dataOpGraph = this.createDataOpGraph(dataOps);
    final Function1<DataOperation, IdentifierInstance<DataOperation, AssemblyContext>> _function_1 = (DataOperation dataOp) -> {
      return IdentifierInstance.<DataOperation, AssemblyContext>createInstance(seffInstance.getAc(), dataOp);
    };
    final Function1<IdentifierInstance<DataOperation, AssemblyContext>, Operation> _function_2 = (IdentifierInstance<DataOperation, AssemblyContext> it) -> {
      return this.getOperation(it);
    };
    final Iterable<Operation> ops = IterableExtensions.<IdentifierInstance<DataOperation, AssemblyContext>, Operation>map(IterableExtensions.<DataOperation, IdentifierInstance<DataOperation, AssemblyContext>>map(dataOps, _function_1), _function_2);
    EList<Operation> _operations = this.getSystem().getOperations();
    Iterables.<Operation>addAll(_operations, ops);
    final HashMap<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, StateRef> stateRefCache = new HashMap<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, StateRef>();
    final HashMap<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, ReturnValueRef> resultRefCache = new HashMap<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, ReturnValueRef>();
    for (final DataOperation dataOp : dataOps) {
      {
        final IdentifierInstance<DataOperation, AssemblyContext> callerInstance = IdentifierInstance.<DataOperation, AssemblyContext>createInstance(seffInstance.getAc(), dataOp);
        final Operation caller = this.getOperation(callerInstance);
        final Set<DataEdge> incomingEdges = dataOpGraph.incomingEdgesOf(dataOp);
        for (final DataEdge incomingEdge : incomingEdges) {
          {
            final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data incomingData = incomingEdge.getData();
            LogicTerm incomingDataRef = null;
            DataOperation _findSource = incomingEdge.findSource();
            boolean _equals = Objects.equal(_findSource, PCM2DFSystemModelTransformation.SEFF_DUMMY_OPERATION);
            if (_equals) {
              final Variable seffVariable = this.getStateVariable(incomingData, seffInstance);
              final StateRef stateRef = PCM2DFSystemModelTransformation.factory.createStateRef();
              stateRef.setStateVariable(seffVariable);
              incomingDataRef = stateRef;
              StateRef _put = stateRefCache.put(incomingData, stateRef);
              boolean _tripleNotEquals = (_put != null);
              if (_tripleNotEquals) {
                throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.");
              }
            } else {
              final IdentifierInstance<DataOperation, AssemblyContext> calleeInstance = IdentifierInstance.<DataOperation, AssemblyContext>createInstance(seffInstance.getAc(), incomingEdge.findSource());
              final Operation callee = this.getOperation(calleeInstance);
              final OperationCall call = this.getOperationCall(caller, callee);
              final Variable calleeVariable = this.getReturnVariable(incomingData, calleeInstance);
              final ReturnValueRef resultRef = PCM2DFSystemModelTransformation.factory.createReturnValueRef();
              resultRef.setCall(call);
              resultRef.setReturnValue(calleeVariable);
              incomingDataRef = resultRef;
              ReturnValueRef _put_1 = resultRefCache.put(incomingData, resultRef);
              boolean _tripleNotEquals_1 = (_put_1 != null);
              if (_tripleNotEquals_1) {
                throw new IllegalStateException("Assumption: every data is only transferred from exactly one source.");
              }
            }
            EList<VariableAssignment> _returnValueAssignments = caller.getReturnValueAssignments();
            List<VariableAssignment> _createReturnValueAssignments = this.createReturnValueAssignments(callerInstance, incomingData, incomingDataRef);
            Iterables.<VariableAssignment>addAll(_returnValueAssignments, _createReturnValueAssignments);
          }
        }
      }
    }
    Iterable<ReturnDataOperation> _filter = Iterables.<ReturnDataOperation>filter(dataOps, ReturnDataOperation.class);
    for (final ReturnDataOperation returnOperation : _filter) {
      {
        final Operation calledOperation = this.getOperation(IdentifierInstance.<DataOperation, AssemblyContext>createInstance(seffInstance.getAc(), ((DataOperation) returnOperation)));
        final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data resultData = returnOperation.getConsumedData();
        final Variable returnValue = this.getReturnVariable(resultData, seffInstance);
        final VariableAssignment returnAssignment = PCM2DFSystemModelTransformation.factory.createVariableAssignment();
        returnAssignment.setVariable(returnValue);
        final ReturnValueRef returnValueRef = PCM2DFSystemModelTransformation.factory.createReturnValueRef();
        returnAssignment.setTerm(returnValueRef);
        returnValueRef.setCall(this.getOperationCall(op, calledOperation));
        final Variable calledOperationReturnValue = this.getReturnVariable(resultData, IdentifierInstance.<ReturnDataOperation, AssemblyContext>createInstance(seffInstance.getAc(), returnOperation));
        EList<Variable> _returnValues = calledOperation.getReturnValues();
        _returnValues.add(calledOperationReturnValue);
        returnValueRef.setReturnValue(calledOperationReturnValue);
        EList<Variable> _returnValues_1 = op.getReturnValues();
        _returnValues_1.add(returnValue);
        EList<VariableAssignment> _returnValueAssignments = op.getReturnValueAssignments();
        _returnValueAssignments.add(returnAssignment);
      }
    }
    final Function1<DataOperation, Boolean> _function_3 = (DataOperation dataOp_1) -> {
      return Boolean.valueOf((!Objects.equal(dataOp_1, PCM2DFSystemModelTransformation.SEFF_DUMMY_OPERATION)));
    };
    final Function1<DataOperation, Boolean> _function_4 = (DataOperation v) -> {
      return Boolean.valueOf(dataOpGraph.outgoingEdgesOf(v).isEmpty());
    };
    final Iterable<DataOperation> consumerOps = IterableExtensions.<DataOperation>filter(IterableExtensions.<DataOperation>filter(dataOpGraph.vertexSet(), _function_3), _function_4);
    EList<OperationCall> _calls = op.getCalls();
    final Function1<DataOperation, Operation> _function_5 = (DataOperation consumerOp) -> {
      return this.getOperation(IdentifierInstance.<DataOperation, AssemblyContext>createInstance(seffInstance.getAc(), consumerOp));
    };
    final Function1<Operation, OperationCall> _function_6 = (Operation consumerOp) -> {
      return this.getOperationCall(op, consumerOp);
    };
    Iterable<OperationCall> _map_1 = IterableExtensions.<Operation, OperationCall>map(IterableExtensions.<DataOperation, Operation>map(consumerOps, _function_5), _function_6);
    Iterables.<OperationCall>addAll(_calls, _map_1);
  }
  
  public List<VariableAssignment> createReturnValueAssignments(final IdentifierInstance<DataOperation, ?> opInstance, final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final LogicTerm term) {
    return this.createReturnValueAssignments2(opInstance.getEntity(), opInstance, data, term);
  }
  
  protected List<VariableAssignment> _createReturnValueAssignments2(final DataOperation op, final IdentifierInstance<DataOperation, ?> opInstance, final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final LogicTerm term) {
    return Collections.<VariableAssignment>unmodifiableList(CollectionLiterals.<VariableAssignment>newArrayList());
  }
  
  protected List<VariableAssignment> _createReturnValueAssignments2(final ReturnDataOperation op, final IdentifierInstance<DataOperation, ?> opInstance, final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final LogicTerm term) {
    List<VariableAssignment> _xblockexpression = null;
    {
      final VariableAssignment assignment = PCM2DFSystemModelTransformation.factory.createVariableAssignment();
      assignment.setTerm(term);
      assignment.setVariable(this.getReturnVariable(data, opInstance));
      _xblockexpression = Collections.<VariableAssignment>unmodifiableList(CollectionLiterals.<VariableAssignment>newArrayList(assignment));
    }
    return _xblockexpression;
  }
  
  protected List<VariableAssignment> _createReturnValueAssignments2(final PerformDataTransmissionOperation op, final IdentifierInstance<DataOperation, ?> opInstance, final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final LogicTerm term) {
    List<VariableAssignment> _xblockexpression = null;
    {
      final Collection<EObject> actionCandidates = EMFUtils.getStereotypedElements("DataProcessingSpecification", op.getContainer());
      final Function1<EntryLevelSystemCall, Boolean> _function = (EntryLevelSystemCall it) -> {
        return Boolean.valueOf(true);
      };
      final EntryLevelSystemCall elsc = IterableExtensions.<EntryLevelSystemCall>findFirst(Iterables.<EntryLevelSystemCall>filter(actionCandidates, EntryLevelSystemCall.class), _function);
      if ((elsc != null)) {
        final OperationSignature calledSignature = elsc.getOperationSignature__EntryLevelSystemCall();
        final OperationProvidedRole providedRole = elsc.getProvidedRole_EntryLevelSystemCall();
        EObject _rootContainer = EcoreUtil.getRootContainer(providedRole);
        final org.palladiosimulator.pcm.system.System pcmSystem = ((org.palladiosimulator.pcm.system.System) _rootContainer);
        final Function1<ProvidedDelegationConnector, Boolean> _function_1 = (ProvidedDelegationConnector it) -> {
          OperationProvidedRole _outerProvidedRole_ProvidedDelegationConnector = it.getOuterProvidedRole_ProvidedDelegationConnector();
          return Boolean.valueOf((_outerProvidedRole_ProvidedDelegationConnector == providedRole));
        };
        final AssemblyContext targetAssembly = IterableExtensions.<ProvidedDelegationConnector>findFirst(Iterables.<ProvidedDelegationConnector>filter(pcmSystem.getConnectors__ComposedStructure(), ProvidedDelegationConnector.class), _function_1).getAssemblyContext_ProvidedDelegationConnector();
        final Function1<SEFFInstance, Boolean> _function_2 = (SEFFInstance seff) -> {
          Signature _describedService__SEFF = seff.getEntity().getDescribedService__SEFF();
          return Boolean.valueOf((_describedService__SEFF == calledSignature));
        };
        final Iterable<SEFFInstance> targetSEFFCandidates = IterableExtensions.<SEFFInstance>filter(this.findAllSEFFs(targetAssembly), _function_2);
        final Function1<SEFFInstance, Boolean> _function_3 = (SEFFInstance it) -> {
          return Boolean.valueOf(true);
        };
        final SEFFInstance targetSEFF = IterableExtensions.<SEFFInstance>findFirst(targetSEFFCandidates, _function_3);
        final List<ParameterBasedData> inputParameters = PCM2DFSystemModelTransformation.getParameterBasedData(targetSEFF.getEntity());
        final Function1<ParameterBasedData, Variable> _function_4 = (ParameterBasedData it) -> {
          return this.getStateVariable(it, targetSEFF);
        };
        final List<Variable> stateVariables = ListExtensions.<ParameterBasedData, Variable>map(inputParameters, _function_4);
      }
      final Function1<ExternalCallAction, Boolean> _function_5 = (ExternalCallAction it) -> {
        return Boolean.valueOf(true);
      };
      final ExternalCallAction eca = IterableExtensions.<ExternalCallAction>findFirst(Iterables.<ExternalCallAction>filter(actionCandidates, ExternalCallAction.class), _function_5);
      if ((eca != null)) {
      }
      _xblockexpression = Collections.<VariableAssignment>unmodifiableList(CollectionLiterals.<VariableAssignment>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected Operation getOperation(final IdentifierInstance<DataOperation, ?> dataOpInstance) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(dataOpInstance);
    final Operation _result;
    synchronized (_createCache_getOperation) {
      if (_createCache_getOperation.containsKey(_cacheKey)) {
        return _createCache_getOperation.get(_cacheKey);
      }
      Operation _createOperation = PCM2DFSystemModelTransformation.factory.createOperation();
      _result = _createOperation;
      _createCache_getOperation.put(_cacheKey, _result);
    }
    _init_getOperation(_result, dataOpInstance);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Operation> _createCache_getOperation = CollectionLiterals.newHashMap();
  
  private void _init_getOperation(final Operation op, final IdentifierInstance<DataOperation, ?> dataOpInstance) {
    op.setName(dataOpInstance.getUniqueName());
    EList<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data> _outgoingData = dataOpInstance.getEntity().getOutgoingData();
    List<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data> _xifexpression = null;
    DataOperation _entity = dataOpInstance.getEntity();
    if ((_entity instanceof ReturnDataOperation)) {
      _xifexpression = dataOpInstance.getEntity().getIncomingData();
    } else {
      _xifexpression = Collections.<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data>unmodifiableList(CollectionLiterals.<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data>newArrayList());
    }
    Iterable<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data> outgoingData = Iterables.<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data>concat(_outgoingData, _xifexpression);
    EList<Variable> _returnValues = op.getReturnValues();
    final Function1<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, Variable> _function = (org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data it) -> {
      return this.getReturnVariable(it, dataOpInstance);
    };
    Iterable<Variable> _map = IterableExtensions.<org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data, Variable>map(outgoingData, _function);
    Iterables.<Variable>addAll(_returnValues, _map);
  }
  
  protected OperationCall getOperationCall(final Caller from, final Operation to) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(from, to);
    final OperationCall _result;
    synchronized (_createCache_getOperationCall) {
      if (_createCache_getOperationCall.containsKey(_cacheKey)) {
        return _createCache_getOperationCall.get(_cacheKey);
      }
      OperationCall _createOperationCall = PCM2DFSystemModelTransformation.factory.createOperationCall();
      _result = _createOperationCall;
      _createCache_getOperationCall.put(_cacheKey, _result);
    }
    _init_getOperationCall(_result, from, to);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, OperationCall> _createCache_getOperationCall = CollectionLiterals.newHashMap();
  
  private void _init_getOperationCall(final OperationCall opCall, final Caller from, final Operation to) {
    opCall.setCaller(from);
    opCall.setCallee(to);
    String _hash = Hash.init(from.getName()).add(to.getName()).getHash();
    String _plus = ("opCall_" + _hash);
    opCall.setName(_plus);
  }
  
  protected DefaultDirectedGraph<DataOperation, DataEdge> createDataOpGraph(final Iterable<DataOperation> dataOps) {
    final DataOperationGraphFactory factory = new DataOperationGraphFactory(PCM2DFSystemModelTransformation.SEFF_DUMMY_OPERATION);
    return factory.createDataOpGraph(dataOps);
  }
  
  protected Variable getStateVariable(final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final IdentifierInstance<?, ?> instance) {
    return this.getVariable(data, PCM2DFSystemModelTransformation.VariablePurpose.STATE, instance);
  }
  
  protected Variable getParameterVariable(final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final IdentifierInstance<?, ?> instance) {
    return this.getVariable(data, PCM2DFSystemModelTransformation.VariablePurpose.PARAMETER, instance);
  }
  
  protected Variable getReturnVariable(final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final IdentifierInstance<?, ?> instance) {
    return this.getVariable(data, PCM2DFSystemModelTransformation.VariablePurpose.RETURN, instance);
  }
  
  protected Variable getVariable(final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final PCM2DFSystemModelTransformation.VariablePurpose purpose, final IdentifierInstance<?, ?> entityInstance) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(data, purpose, entityInstance);
    final Variable _result;
    synchronized (_createCache_getVariable) {
      if (_createCache_getVariable.containsKey(_cacheKey)) {
        return _createCache_getVariable.get(_cacheKey);
      }
      Variable _createVariable = PCM2DFSystemModelTransformation.factory.createVariable();
      _result = _createVariable;
      _createCache_getVariable.put(_cacheKey, _result);
    }
    _init_getVariable(_result, data, purpose, entityInstance);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Variable> _createCache_getVariable = CollectionLiterals.newHashMap();
  
  private void _init_getVariable(final Variable variable, final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final PCM2DFSystemModelTransformation.VariablePurpose purpose, final IdentifierInstance<?, ?> entityInstance) {
    variable.setDatatype(this.getDataType(data.getType()));
    StringConcatenation _builder = new StringConcatenation();
    String _uniqueName = PCM2DFSystemModelTransformation.uniqueName(data);
    _builder.append(_uniqueName);
    _builder.append("_");
    _builder.append(purpose);
    _builder.append("_");
    String _uniqueName_1 = entityInstance.getUniqueName();
    _builder.append(_uniqueName_1);
    variable.setName(_builder.toString());
  }
  
  protected edu.kit.ipd.sdq.dataflow.systemmodel.DataType getDataType(final DataType dataType) {
    PCM2DFSystemModelTransformation.DataTypeWrapper _dataTypeWrapper = new PCM2DFSystemModelTransformation.DataTypeWrapper(dataType);
    return this.getDataTypeInternal(_dataTypeWrapper);
  }
  
  protected edu.kit.ipd.sdq.dataflow.systemmodel.DataType getDataTypeInternal(final DataType dataType) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(dataType);
    final edu.kit.ipd.sdq.dataflow.systemmodel.DataType _result;
    synchronized (_createCache_getDataTypeInternal) {
      if (_createCache_getDataTypeInternal.containsKey(_cacheKey)) {
        return _createCache_getDataTypeInternal.get(_cacheKey);
      }
      edu.kit.ipd.sdq.dataflow.systemmodel.DataType _createDataType = PCM2DFSystemModelTransformation.factory.createDataType();
      _result = _createDataType;
      _createCache_getDataTypeInternal.put(_cacheKey, _result);
    }
    _init_getDataTypeInternal(_result, dataType);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, edu.kit.ipd.sdq.dataflow.systemmodel.DataType> _createCache_getDataTypeInternal = CollectionLiterals.newHashMap();
  
  private void _init_getDataTypeInternal(final edu.kit.ipd.sdq.dataflow.systemmodel.DataType dt, final DataType dataType) {
    dt.setName(PCM2DFSystemModelTransformation.uniqueName(dataType));
    EList<edu.kit.ipd.sdq.dataflow.systemmodel.DataType> _datatypes = this.getSystem().getDatatypes();
    _datatypes.add(dt);
  }
  
  protected static String uniqueName(final Entity entity) {
    StringConcatenation _builder = new StringConcatenation();
    String _entityName = entity.getEntityName();
    _builder.append(_entityName);
    _builder.append("_(");
    String _id = entity.getId();
    _builder.append(_id);
    _builder.append(")");
    return _builder.toString();
  }
  
  protected static String uniqueName(final Identifier entity) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = entity.getClass().getName();
    _builder.append(_name);
    _builder.append("_");
    String _id = entity.getId();
    _builder.append(_id);
    return _builder.toString();
  }
  
  protected static String uniqueName(final DataType dataType) {
    return PCM2DFSystemModelTransformation.uniqueNameDataType(dataType);
  }
  
  protected static String _uniqueNameDataType(final PrimitiveDataType dataType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("primitiveDataType_");
    String _name = dataType.getType().getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  protected static String _uniqueNameDataType(final Entity dataType) {
    return PCM2DFSystemModelTransformation.uniqueName(dataType);
  }
  
  protected static String _uniqueNameDataType(final PCM2DFSystemModelTransformation.DataTypeWrapper dataType) {
    return PCM2DFSystemModelTransformation.uniqueNameDataType(dataType.delegate);
  }
  
  protected Iterable<SEFFInstance> findAllSEFFs(final org.palladiosimulator.pcm.system.System system) {
    final Function1<AssemblyContext, HashSet<SEFFInstance>> _function = (AssemblyContext it) -> {
      return this.findAllSEFFs(it);
    };
    return Iterables.<SEFFInstance>concat(ListExtensions.<AssemblyContext, HashSet<SEFFInstance>>map(system.getAssemblyContexts__ComposedStructure(), _function));
  }
  
  protected HashSet<SEFFInstance> findAllSEFFs(final AssemblyContext assembly) {
    HashSet<SEFFInstance> _xblockexpression = null;
    {
      final HashSet<SEFFInstance> seffs = new HashSet<SEFFInstance>();
      final LinkedList<AssemblyContext> acQueue = new LinkedList<AssemblyContext>(Collections.<AssemblyContext>unmodifiableList(CollectionLiterals.<AssemblyContext>newArrayList(assembly)));
      while ((!acQueue.isEmpty())) {
        {
          final AssemblyContext ac = acQueue.pop();
          final RepositoryComponent component = ac.getEncapsulatedComponent__AssemblyContext();
          if ((component instanceof ComposedStructure)) {
            EList<AssemblyContext> _assemblyContexts__ComposedStructure = ((ComposedStructure)component).getAssemblyContexts__ComposedStructure();
            Iterables.<AssemblyContext>addAll(acQueue, _assemblyContexts__ComposedStructure);
          } else {
            if ((component instanceof BasicComponent)) {
              final Function1<ResourceDemandingSEFF, SEFFInstance> _function = (ResourceDemandingSEFF seff) -> {
                return SEFFInstance.createInstance(ac, seff);
              };
              Iterable<SEFFInstance> _map = IterableExtensions.<ResourceDemandingSEFF, SEFFInstance>map(Iterables.<ResourceDemandingSEFF>filter(((BasicComponent)component).getServiceEffectSpecifications__BasicComponent(), ResourceDemandingSEFF.class), _function);
              Iterables.<SEFFInstance>addAll(seffs, _map);
            }
          }
        }
      }
      _xblockexpression = seffs;
    }
    return _xblockexpression;
  }
  
  protected Iterable<DataOperation> findAllDataOperations(final ScenarioBehaviour sb) {
    final Function1<AbstractUserAction, List<DataOperation>> _function = (AbstractUserAction it) -> {
      return this.findAllDataOperations(it);
    };
    return Iterables.<DataOperation>concat(ListExtensions.<AbstractUserAction, List<DataOperation>>map(sb.getActions_ScenarioBehaviour(), _function));
  }
  
  protected Iterable<DataOperation> findAllDataOperations(final ResourceDemandingSEFF seff) {
    final Function1<AbstractAction, List<DataOperation>> _function = (AbstractAction it) -> {
      return this.findAllDataOperations(it);
    };
    return Iterables.<DataOperation>concat(ListExtensions.<AbstractAction, List<DataOperation>>map(seff.getSteps_Behaviour(), _function));
  }
  
  protected List<DataOperation> findAllDataOperations(final EObject action) {
    EList<DataOperation> _xblockexpression = null;
    {
      boolean _hasAppliedStereotype = StereotypeAPI.hasAppliedStereotype(Collections.<EObject>unmodifiableSet(CollectionLiterals.<EObject>newHashSet(action)), "DataProcessingSpecification");
      boolean _not = (!_hasAppliedStereotype);
      if (_not) {
        return Collections.<DataOperation>unmodifiableList(CollectionLiterals.<DataOperation>newArrayList());
      }
      Object _taggedValue = StereotypeAPI.<Object>getTaggedValue(action, "dataProcessingContainer", "DataProcessingSpecification");
      final DataProcessingContainer dataProcessingContainer = ((DataProcessingContainer) _taggedValue);
      _xblockexpression = dataProcessingContainer.getOperations();
    }
    return _xblockexpression;
  }
  
  protected static List<ParameterBasedData> getParameterBasedData(final ServiceEffectSpecification seff) {
    boolean _isStereotypeApplied = StereotypeAPI.isStereotypeApplied(seff, "DataSeffSpecification");
    if (_isStereotypeApplied) {
      Object _taggedValue = StereotypeAPI.<Object>getTaggedValue(seff, "dataSeffSpecification", "DataSeffSpecification");
      DataSEFFSpecification dataParameters = ((DataSEFFSpecification) _taggedValue);
      return dataParameters.getInputData();
    }
    return Collections.<ParameterBasedData>unmodifiableList(CollectionLiterals.<ParameterBasedData>newArrayList());
  }
  
  protected ValueSetType transformCharacteristicType(final CharacteristicType characteristic) {
    if (characteristic instanceof EnumCharacteristicType) {
      return _transformCharacteristicType((EnumCharacteristicType)characteristic);
    } else if (characteristic != null) {
      return _transformCharacteristicType(characteristic);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(characteristic).toString());
    }
  }
  
  public List<VariableAssignment> createReturnValueAssignments2(final DataOperation op, final IdentifierInstance<DataOperation, ?> opInstance, final org.palladiosimulator.pcm.dataprocessing.dataprocessing.data.Data data, final LogicTerm term) {
    if (op instanceof ReturnDataOperation) {
      return _createReturnValueAssignments2((ReturnDataOperation)op, opInstance, data, term);
    } else if (op instanceof PerformDataTransmissionOperation) {
      return _createReturnValueAssignments2((PerformDataTransmissionOperation)op, opInstance, data, term);
    } else if (op != null) {
      return _createReturnValueAssignments2(op, opInstance, data, term);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(op, opInstance, data, term).toString());
    }
  }
  
  protected static String uniqueNameDataType(final CDOObject dataType) {
    if (dataType instanceof Entity) {
      return _uniqueNameDataType((Entity)dataType);
    } else if (dataType instanceof PCM2DFSystemModelTransformation.DataTypeWrapper) {
      return _uniqueNameDataType((PCM2DFSystemModelTransformation.DataTypeWrapper)dataType);
    } else if (dataType instanceof PrimitiveDataType) {
      return _uniqueNameDataType((PrimitiveDataType)dataType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dataType).toString());
    }
  }
}
