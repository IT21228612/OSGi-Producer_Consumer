
package dietPlanSubscriber_pkg;

import java.util.List;
import java.util.Scanner;

import dietPlanPublisher_pkg.DietPlan;
import dietPlanPublisher_pkg.DietPlanPublisher;

public class DietPlanSubscriberImpl implements DietPlanSubscriber {
	
	String input;
	String dietPlan_ID;
    String dietPlan_name;
    String dp_weight;
    String dp_height;
    String dietPlan;
	String dietPlan_period;
	String dp_bmiCategory;
	Scanner sc = new Scanner(System.in);

	public static final String ADD ="add";
	public static final String All ="all";
	public static final String DELETE ="delete";
	public static final String BMI ="bmi";
	public static final String FIND ="find";
	
	@Override
	public void getService(DietPlanPublisher DietPlanpublisher) {
		  System.out.println();
		  System.out.println("************* Gym System ************* ");
	      System.out.println("      *** Diet Plan Subsystem ***           \n");
	      System.out.println();
	      System.out.println("*** Select the service from below ***");
	      System.out.println();
	      
	      while(true) {
	    	  input = getInput();
	    	  
	    	  if(input.equalsIgnoreCase(ADD)) {
	    		  addRecord( DietPlanpublisher);
	    	  }
	    	  else if (input.equalsIgnoreCase(All)) {
	    		  getAllRecords( DietPlanpublisher);
	    	  }
	    	  else if (input.equalsIgnoreCase(DELETE)) {
	    		  deleteRecord( DietPlanpublisher);
	    	  }
	    	  else if (input.equalsIgnoreCase(BMI)) {
	    		  bmi(DietPlanpublisher);
	    	  }
	    	  else if (input.equalsIgnoreCase(FIND)) {
	    		  findBestDietPlans(DietPlanpublisher);
	    	  }
	    	  else {
	    		  System.out.println("*** Invalid ***");
	    	  }
	      }
		
	}

public String getInput() {
	   System.out.println("-------------List Of Services----------\n");
	   System.out.println("Add Diet Plan:                     'Add'");
	   System.out.println("View  All the Diet Plans:          'All'");
	   System.out.println("Delete a Diet Plan:                'Delete'\n");
	   System.out.println("Calculate BMI Value:               'BMI'");
	   System.out.println("Find The BEST Diet Plan :          'Find'\n");
	   String input =sc.nextLine();
	   return input;
	   
   }
   
   public void addRecord(DietPlanPublisher DietPlanPublisher) {
	   
	   System.out.println();
	   System.out.print("Enter Diet Plan ID: ");
	   dietPlan_ID = sc.nextLine();
	   
	   System.out.print("Enter Diet Plan Name: ");
	   dietPlan_name = sc.nextLine();
	   
	   System.out.print("Enter Diet Plan: ");
	   dietPlan = sc.nextLine();
	   
	   System.out.print("Enter Diet Plan Period [Months]: ");
	   dietPlan_period = sc.nextLine();
	   
	   System.out.print("Enter BMI Category [Obese / Overweight / Normal Weight /  Underweight]: ");
	   dp_bmiCategory = sc.nextLine();
	   
	   
	   
	   String temp = DietPlanPublisher.addDietPlan( dietPlan_ID,  dietPlan_name,  dp_weight,  dp_height,  dietPlan, dietPlan_period, dp_bmiCategory);
	   System.out.println(temp);
	   System.out.println();
   }
   
   public void getAllRecords(DietPlanPublisher DietPlanPublisher) {
	   List<DietPlan> DietPlans = DietPlanPublisher.getAllDietPlan();
	   System.out.println();
	   
	   System.out.println("=====Displaying all Diet Plans==== ");
	   System.out.println();
	   
	   System.out.println("ID  \t\tDiet Plan Name \t\t\t\t   Diet Plan \t\t\t\t\t Period \t\t BMI Category");
	   for(DietPlan DietPlan : DietPlans ) {
		   System.out.println();
		   System.out.println(DietPlan.getDietPlan_ID() +"\t\t " +" "+ DietPlan.getDietPlan_name() +"\t\t\t " +" "+ DietPlan.getDietPlan() +"\t\t " +" "+ DietPlan.getDietPlan_period() +"\t\t\t " +" "+ DietPlan.getDp_bmiCategory());
		   
		   
		   System.out.println();
	   }
	   
	   System.out.println();
   }
   

   private void deleteRecord(DietPlanPublisher DietPlanPublisher) {
		String DietPlan_id;
		
		System.out.print("Enter Diet Plan ID to be deleted: ");
		DietPlan_id = sc.nextLine();
		
		DietPlanPublisher.deleteDietPlan(DietPlan_id);
		System.out.println();
	}
   
   private void bmi(DietPlanPublisher DietPlanPublisher){
	    
	   double weight;
	   double height;
	   
		System.out.print("Enter Your Weight[Kg] : ");
		weight = sc.nextDouble();
		System.out.print("Enter Your Height[cm] : ");
		height = sc.nextDouble();
		
		sc.nextLine();
		
		DietPlanPublisher.BMICalculator(height,weight);
		System.out.println();
	   
   }
   
   private void findBestDietPlans(DietPlanPublisher dietPlanPublisher) {
	    String category;

	    System.out.print("Enter BMI Category [Obese / Overweight / Normal Weight /  Underweight]: ");
	    category = sc.nextLine();

	    List<DietPlan> bestDietPlans = dietPlanPublisher.findBestDietPlan(category);
	    
	    if (!bestDietPlans.isEmpty()) {
	        System.out.println("\nBest Diet Plans for " + category + ":");
	        for (DietPlan dietPlan : bestDietPlans) {
	            System.out.println("*** " + dietPlan.getDietPlan() + " ***");
	        }
	    } else {
	        System.out.println("\n*** No diet plans found for BMI category: " + category + " ***");
	    }

	    System.out.println();
	}

   
	

}
