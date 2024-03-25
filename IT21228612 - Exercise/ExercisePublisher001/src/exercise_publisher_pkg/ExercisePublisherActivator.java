package exercise_publisher_pkg;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ExercisePublisherActivator implements BundleActivator {

    ServiceRegistration<?> adminServiceReg;
    ServiceRegistration<?> customerServiceReg;

    public void start(BundleContext context) throws Exception {
        System.out.println("Exercise Publisher Started\n\n");
        
        // Register the service for ExercisePublisher_admin_interface
        ExercisePublisher_admin_interface adminService = new ExercisePublisher_Impl();
        adminServiceReg = context.registerService(ExercisePublisher_admin_interface.class.getName(), adminService, null);

       }

    public void stop(BundleContext Context) throws Exception {
        System.out.println("Exercise Publisher Stopped");
    }
}
