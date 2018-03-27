/**
 */
package edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.provider;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Data;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Flow;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.Node;


public class FlowItemProvider extends edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.provider.orig.FlowItemProvider {

	public FlowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		Optional<Flow> flow = Optional.ofNullable(object).filter(Flow.class::isInstance).map(Flow.class::cast);
		if (flow.isPresent()) {
			String startNodeName = flow.map(Flow::getStartNode).map(Node::getName).orElse("");
			String endNodeName = flow.map(Flow::getEndNode).map(Node::getName).orElse("");
			String dataList = flow.map(Flow::getData).map(Collection::stream).map(s -> s.map(Data::getName).collect(Collectors.joining(", "))).orElse("");
			return String.format("%s: %s -> %s (%s)", getString("_UI_Flow_type"), startNodeName, endNodeName, dataList);			
		}

		String label = ((Flow) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Flow_type")
				: getString("_UI_Flow_type") + " " + label;
	}

}
