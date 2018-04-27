package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.tests.accesscontrol;

import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Streams;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.DataFlowDiagram;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.IPrologGeneratorContributor;

public class ContributorWrapper implements IPrologGeneratorContributor {

	private final IPrologGeneratorContributor target;
	
	public ContributorWrapper(IPrologGeneratorContributor target) {
		this.target = target;
	}

	public String getIdentifier() {
		return target.getIdentifier();
	}

	public Iterable<URI> getOperationModels() {
		return convertURIs(target.getOperationModels());
	}

	public String getFacts(DataFlowDiagram diagram) {
		return target.getFacts(diagram);
	}

	public String getRules(DataFlowDiagram diagram) {
		return target.getRules(diagram);
	}

	public URI getOperationModel() {
		return convertURI(target.getOperationModel());
	}

	public Iterable<URI> getCharacteristicModels() {
		return convertURIs(target.getCharacteristicModels());
	}

	public URI getCharacteristicModel() {
		return convertURI(target.getCharacteristicModel());
	}

	protected Iterable<URI> convertURIs(Iterable<URI> uris) {
		return Streams.stream(uris).map(this::convertURI).collect(Collectors.toList());
	}

	protected URI convertURI(URI uri) {
		if (!uri.isPlatformPlugin()) {
			return uri;
		}

		return URI.createPlatformResourceURI(uri.toPlatformString(true), true);
	}

}
