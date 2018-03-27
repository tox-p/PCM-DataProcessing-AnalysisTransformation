package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.ui;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

import com.google.inject.Guice;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.Activator;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.PrologGeneratorDelegator;
import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.PrologGeneratorModule;
import edu.kit.ipd.sdq.mdsd.ecore2txt.handler.AbstractEcoreIFile2TxtHandler;
import edu.kit.ipd.sdq.mdsd.ecore2txt.util.Ecore2TxtUtil;

public class GeneratorHandler extends AbstractEcoreIFile2TxtHandler {

	@Override
	public String getPlugInID() {
		return Activator.getInstance().getPluginId();
	}

	@Override
	public void executeEcore2TxtGenerator(List<IFile> filteredSelection, ExecutionEvent event, String plugInID)
			throws ExecutionException {
		// TODO check selected files
		
		PrologGeneratorDelegator generatorDelegator = new PrologGeneratorDelegator();
		PrologGeneratorModule module = new PrologGeneratorModule();
		Guice.createInjector(module).injectMembers(generatorDelegator);
		
		Ecore2TxtUtil.generateFromSelectedFilesInFolder(filteredSelection, module,
				generatorDelegator, false, false);
	}

}
