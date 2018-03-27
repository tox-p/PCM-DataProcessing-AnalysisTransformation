package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator;

import java.util.Arrays;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.internal.xtend.util.Triplet;

import com.google.inject.Inject;

import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGenerator;

public class PrologGeneratorDelegator extends AbstractEcore2TxtGenerator {

	private static final String FILE_EXTENSION = "pl";
	
	@Inject
	private IEcore2TxtGenerator generator;
	
	@Override
	public String postProcessGeneratedContents(String contents) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Triplet<String, String, String>> generateContentsFromResource(Resource inputResource) {
		String content = generator.generateContentsFromResource(inputResource);
		String folderName = getFolderNameForResource(inputResource);
		String fileName = getFileNameForResource(inputResource);
		return Arrays.asList(new Triplet<>(content, folderName, fileName));
	}

	@Override
	public String getFolderNameForResource(Resource inputResource) {
		return "resource-gen";
	}

	@Override
	public String getFileNameForResource(Resource inputResource) {
		return inputResource.getURI().trimFileExtension().appendFileExtension(FILE_EXTENSION).lastSegment();
	}

}
