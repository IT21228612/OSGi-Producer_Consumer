package com.mtit.SupplimentPublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class SupplimentActivator implements BundleActivator {

	ServiceRegistration memberServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		    System.out.println("Started Suppliment Publisher");
            SupplimentPublisher supplimentPublisher = new SupplimentPublishImpl();
            memberServiceRegistration = context.registerService(SupplimentPublisher.class.getName(), supplimentPublisher, null);		
	}

	public void stop(BundleContext Context) throws Exception {
		   System.out.println("Stopped Suppliment Publisher");
		
	}

}
