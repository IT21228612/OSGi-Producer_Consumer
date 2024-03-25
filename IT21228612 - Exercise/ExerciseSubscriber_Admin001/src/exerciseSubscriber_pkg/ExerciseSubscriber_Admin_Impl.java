package exerciseSubscriber_pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exercise_publisher_pkg.Exercise;
import exercise_publisher_pkg.ExercisePublisher_admin_interface;

public class ExerciseSubscriber_Admin_Impl implements ExerciseSubscriber_Admin_interface {
	
	String serviceName;
	String exerciseID;
	String name;
	String muscle;
	int time_span;
	String goal;
	private static Scanner sc = new Scanner(System.in);

	public static final String addCommand ="add";
	public static final String allCommand ="all";
	public static final String deleteCommand ="delete";
	public static final String muscleCommand ="by muscle";
	public static final String scheduleCommand ="schedule";
	public static final String exportCommand ="export";
	
	public static void stopService() {
	    // Close the scanner used for input
	    if (sc != null) {
	        sc.close();
	    }
	}
	
	@Override
	public void getService(ExercisePublisher_admin_interface exercisePublisher) {
	      System.out.println("************* Gym System ************* ");
	      System.out.println("        **Exercises Subsystem**           \n");
	    
	      int count = 0 ;
	      
	      while(count<50) {
	    	  serviceName = selectService();
	    	  
	    	  if(serviceName.equalsIgnoreCase(addCommand)) {
	    		  addExerciseRecord(exercisePublisher);
	    	  }
	    	  else if (serviceName.equalsIgnoreCase(allCommand)) {
	    		  getAllExerciseRecords(exercisePublisher);
	    	  }
	    	  else if (serviceName.equalsIgnoreCase(deleteCommand)) {
	    		  deleteExerciseRecord(exercisePublisher);
	    	  }

	    	  else if (serviceName.equalsIgnoreCase(muscleCommand)) {
	    		  getExerciseByMuscle(exercisePublisher);
	    	  }
	    	  else if (serviceName.equalsIgnoreCase(scheduleCommand)) {
	    		  generateSchedule(exercisePublisher);
	    	  }
	    	  else if (serviceName.equalsIgnoreCase(exportCommand)) {
	    		  exportExercises(exercisePublisher);
	    	  }
	    	  else {
	    		  System.out.println("Invalid service!!!!!    Enter Service again....");
	    	  }
	    	  
	    	  count++ ;
	      }
		
	}

public String selectService() {
	  System.out.println("Please select a service from the services listed below\n");
	   System.out.println("-------------List Of Services----------\n");
	   System.out.println("To Add an Exercise: Enter 'add'");
	   System.out.println("To View All Exercises: Enter 'all'");
	   System.out.println("To Delete an Exercise: Enter 'Delete'");
	   System.out.println("View Exercises based on the muscle you want improve: Enter 'by muscle'");
	   System.out.println("Generate Exercise Schedule: Enter 'schedule'");
	   System.out.println("Export all exercises to a CSV file: Enter 'export'");
	   System.out.println();
	   String userInputCommand =sc.nextLine();
	   return userInputCommand;
	   
   }
   
   public void addExerciseRecord(ExercisePublisher_admin_interface exercisePublisher) {
	   
	   System.out.println("--Add Exercise--\n");
	   
	   System.out.println("Enter Exercise ID:");
	   exerciseID = sc.nextLine();
	
	   System.out.println("Enter Exercise Name:");
	   name = sc.nextLine();
	   
	   System.out.println("Enter Exercise Muscle:");
	   muscle = sc.nextLine();
	   
	   System.out.println("Enter Exercise Goal (Weight loss / Muscle gain / Cardio) :");
	   goal = sc.nextLine();
	   
	   System.out.println("Enter Exercise Time Span (in minutes) : ");
	   time_span = sc.nextInt();
	   
	   sc.nextLine(); // Consume newline character after taking integer input
	   
	   String status = exercisePublisher.addExercise(exerciseID, name, muscle,time_span,goal);
	   System.out.println(status);
	   System.out.println();
   }
   
   public void getAllExerciseRecords(ExercisePublisher_admin_interface exercisePublisher) {
	   List<Exercise> exercisesList = exercisePublisher.getAllExercises();
	   
	   System.out.println("--View All Exercises--\n");
	   
	// Check if the list is empty
	    if (exercisesList.isEmpty()) {
	        System.out.println("No exercises found.");
	    } else {
	        for(Exercise ex : exercisesList) {
	            System.out.println();
	            System.out.println("Exercise ID: " + ex.getExerciseID());
	            System.out.println("Exercise Name: " + ex.getExerciseName());
	            System.out.println("Exercise Muscle: " + ex.getExerciseMuscle());
	            System.out.println("Exercise Goal: " + ex.getGoal());
	            System.out.println("Exercise Time Span: " + ex.getExerciseTimeSpan() + " mins");
	           
	            System.out.println();
	        }
	    }
	   
	   System.out.println();
   }
   

   private void deleteExerciseRecord(ExercisePublisher_admin_interface exercisePublisher) {
		String id;
		
		System.out.println("--Delete an Exercise--\n");
		System.out.println("Enter Exercise ID to be deleted: ");
		id = sc.nextLine();
		exercisePublisher.deleteExercise(id);
		System.out.println();
	}
public void getExerciseByMuscle(ExercisePublisher_admin_interface exercisePublisher) {
	   
	   System.out.println("--View Exercises based on muscle--\n");
	   
	   System.out.println("Enter Exercise Muscle: ");
	   String muscle = sc.nextLine();
	   List<Exercise> exercisesList = exercisePublisher.getExercisesByMuscle_customer(muscle);
	   
	  
	// Check if the list is empty
	    if (exercisesList.isEmpty()) {
	        System.out.println("No exercises found for muscle: " + muscle);
	    } else {
	        for (Exercise ex : exercisesList) {
	            System.out.println();
	            System.out.println("Exercise Name: " + ex.getExerciseName());
	            System.out.println("Exercise Muscle: " + ex.getExerciseMuscle());
	            System.out.println("Exercise Goal: " + ex.getGoal());
	            System.out.println("Exercise Time Span: " + ex.getExerciseTimeSpan() + " mins");

	            System.out.println();
	        }
	    }
	   
	   System.out.println();
   }

   
   public void generateSchedule(ExercisePublisher_admin_interface exercisePublisher) {
	   
	    System.out.println("--Generate Exercise Schedule--\n");
	   
	    System.out.println("Enter your goals (Weight loss / Muscle gain / Cardio)..If you have more than one goal, separate them by a comma: ");
	    String goalsInput = sc.nextLine();
	   
	    // Split the input string based on commas
	    String[] goalsArray = goalsInput.split(",");
	   
	    // Create an ArrayList to store the goals
	    ArrayList<String> goalsList = new ArrayList<>();
	   
	    // Add the goals to the ArrayList
	    for (String goal : goalsArray) {
	        goalsList.add(goal.trim()); // Trim to remove leading/trailing spaces
	    }
	   
	    List<Exercise> exerciseSchedule = exercisePublisher.generateExerciseSchedule_customer(goalsList);
	    
	 // Check if the list is empty
	    if (exerciseSchedule.isEmpty()) {
	        System.out.println("No exercises found for the specified goals\n\n.");
	    } else {
	        System.out.println("-Your Schedule-\n");
	        for (Exercise ex : exerciseSchedule) {
	            System.out.println("Exercise Name: " + ex.getExerciseName());
	            System.out.println("Exercise Time Span: " + ex.getExerciseTimeSpan() + " mins");
	            System.out.println();
	        }
	    }
	}
   
   public void exportExercises(ExercisePublisher_admin_interface exercisePublisher) {
	   
	   String filePath;
	   
	   System.out.println("--Export Exercises--\n");
	   
	   System.out.println("Enter folder path you want to save the CSV file :");
	   System.out.println("****Make sure you have entered a SLASH at the end of your path *****");
	   filePath = sc.nextLine();
	   
	   exercisePublisher.exportExercisesToCSV(filePath+"exercises_List.csv");
	   
	   
	   
   }
   
	

}
