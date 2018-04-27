package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.contribution;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.eclipse.emf.common.util.URI;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.metamodel.flow.DataFlowDiagram;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol.Activator;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.contributors.IPrologGeneratorContributor;

public class AccessControlContributor implements IPrologGeneratorContributor {

	@Override
	public URI getOperationModel() {
		return URI.createPlatformPluginURI(
				String.format("%s/model/OperationCatalogue.xmi", Activator.getInstance().getBundleId()), false);
	}

	@Override
	public String getRules(DataFlowDiagram diagram) {
		try (InputStream is = getClass().getResourceAsStream("rules.pl")) {
			return IOUtils.toString(is, StandardCharsets.UTF_8.name());
		} catch (IOException e) {
			return "% ERROR: failed to gather rules";
		}
	}

}
