package exerciseSubscriber_pkg;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;



//           COMPLEX SCENARIO
 
// 		This class accomplish Dynamic Service Discovery and Registration
//		by using ServiceTracker 


import exercise_publisher_pkg.ExercisePublisher_admin_interface;

public class ExerciseSubscriber_Admin_Activator implements BundleActivator {

    private ServiceTracker<ExercisePublisher_admin_interface, ExercisePublisher_admin_interface> serviceTracker;

    public void start(BundleContext context) throws Exception {
        System.out.println("Exercise Subscriber admin Started\n\n\n");

        // Create a service tracker to monitor ExercisePublisher_admin_interface services
        serviceTracker = new ServiceTracker<>(context, ExercisePublisher_admin_interface.class.getName(), new ServiceTrackerCustomizer<ExercisePublisher_admin_interface, ExercisePublisher_admin_interface>() {
            public ExercisePublisher_admin_interface addingService(ServiceReference<ExercisePublisher_admin_interface> reference) {
                // Get the service when it's available
                ExercisePublisher_admin_interface exercisePublisher = context.getService(reference);
                // Initialize and start ExerciseSubscriber_Admin_Impl with the obtained service
                ExerciseSubscriber_Admin_interface exerciseSubscriber = new ExerciseSubscriber_Admin_Impl();
                exerciseSubscriber.getService(exercisePublisher);
                return exercisePublisher;
            }

            public void modifiedService(ServiceReference<ExercisePublisher_admin_interface> reference, ExercisePublisher_admin_interface service) {
                // No action needed when service is modified
            }

            public void removedService(ServiceReference<ExercisePublisher_admin_interface> reference, ExercisePublisher_admin_interface service) {
                // Stop ExerciseSubscriber_Admin_Impl when service is removed
                ExerciseSubscriber_Admin_Impl.stopService();
                System.err.println("ExercisePublisher_admin_interface service is not available.");
            }
        });
        serviceTracker.open();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Exercise Subscriber admin stopped");
        // Close the service tracker when the bundle is stopped
        serviceTracker.close();
    }
}
