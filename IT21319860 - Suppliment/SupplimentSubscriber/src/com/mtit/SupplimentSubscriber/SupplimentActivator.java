package com.mtit.SupplimentSubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.SupplimentPublisher.SupplimentPublisher;

public class SupplimentActivator implements BundleActivator {

      ServiceReference serviceReference;
      Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
			System.out.println("Started Suppliment Subscriber");
			serviceReference = context.getServiceReference(SupplimentPublisher.class.getName());
			
			SupplimentPublisher supplimentPublisher = (SupplimentPublisher)context.getService(serviceReference);
		     SupplimentSubscriber supplimentSubscriber = new SupplimentSubscriberImpl();
		     supplimentSubscriber.getService(supplimentPublisher);      
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopped Suppliment Subscriber");
	
	}

}
