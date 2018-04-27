package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational.contribution;

import org.eclipse.emf.common.util.URI;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.IPrologGeneratorContributor;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.relational.Activator;

public class RelationalContributor implements IPrologGeneratorContributor {

	@Override
	public URI getOperationModel() {
		return URI.createPlatformPluginURI(
				String.format("%s/model/OperationCatalogue.xmi", Activator.getInstance().getBundleId()), false);
	}

}
