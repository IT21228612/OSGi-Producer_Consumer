package dietPlanPublisher_pkg;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DietPlanActivator implements BundleActivator {

	ServiceRegistration DietPlanServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		   System.out.println("DietPlan Publisher Started");
            DietPlanPublisher DietPlanPublisher = new DietPlanPublishImpl();
          DietPlanServiceRegistration = context.registerService(DietPlanPublisher.class.getName(), DietPlanPublisher, null);		
	}

	public void stop(BundleContext Context) throws Exception {
		   System.out.println("DietPlan Publisher Stopped");
		
	}

}
