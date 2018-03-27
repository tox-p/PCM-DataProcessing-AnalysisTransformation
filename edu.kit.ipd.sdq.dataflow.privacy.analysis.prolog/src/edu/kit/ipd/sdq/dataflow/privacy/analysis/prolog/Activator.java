package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog;

import java.util.Optional;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static Activator instance;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setInstance(this);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		setInstance(null);
		super.stop(context);
	}

	protected static void setInstance(Activator instance) {
		Activator.instance = instance;
	}

	public static Activator getInstance() {
		return instance;
	}

	public String getPluginId() {
		return Optional.ofNullable(getInstance()).map(Plugin::getBundle).map(Bundle::getSymbolicName).orElse(null);
	}
}
