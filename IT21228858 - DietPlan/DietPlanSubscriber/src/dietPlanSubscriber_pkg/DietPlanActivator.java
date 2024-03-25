package dietPlanSubscriber_pkg;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import dietPlanPublisher_pkg.DietPlanPublisher;

public class DietPlanActivator implements BundleActivator {

      ServiceReference serviceReference;
      Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
			System.out.println("Started DietPlan Subscriber");
	          serviceReference = context.getServiceReference(DietPlanPublisher.class.getName());
			
			DietPlanPublisher DietPlanPublisher = (DietPlanPublisher)context.getService(serviceReference);
		     DietPlanSubscriber DietPlanSubscriber = new DietPlanSubscriberImpl();
		     DietPlanSubscriber.getService(DietPlanPublisher);     
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopped DietPlan Subscriber");
	
	}

}
