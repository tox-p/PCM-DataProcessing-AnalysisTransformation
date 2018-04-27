package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin implements IActivator {
	
	private static IActivator instance = new IActivator() {
		
		@Override
		public String getBundleId() {
			return "edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.accesscontrol";
		}
	};

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

	private static void setInstance(Activator object) {
		instance = object;
	}

	public static IActivator getInstance() {
		return instance;
	}

	@Override
	public String getBundleId() {
		return getBundle().getSymbolicName();
	}
	
}
