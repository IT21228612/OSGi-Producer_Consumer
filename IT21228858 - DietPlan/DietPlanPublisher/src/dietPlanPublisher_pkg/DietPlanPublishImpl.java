package dietPlanPublisher_pkg;
import java.util.ArrayList;
import java.util.List;

public class DietPlanPublishImpl  implements DietPlanPublisher {
	
	public List<DietPlan> DietPlans = new ArrayList<DietPlan>();

	//adding a new record 
	@Override
	public String addDietPlan(String dietPlan_ID, String dietPlan_name, String dp_weight, String dp_height, String dietPlan,String dietPlan_period, String dp_bmiCategory) {
          DietPlan DietPlan = new DietPlan ( dietPlan_ID,  dietPlan_name,  dp_weight,  dp_height,  dietPlan, dietPlan_period, dp_bmiCategory);
          DietPlans.add(DietPlan);
          return "\n***\tNew Record : " + DietPlan.getDietPlan_name() + " Diet Plan For " + DietPlan.getDp_bmiCategory() +" " + "people" + "  " + "entered successfully!\t***";
     
	}

	//Get all records 
	@Override
	public List <DietPlan> getAllDietPlan() {
		return DietPlans;
			
	}

	//Delete Record
	@Override
	public void deleteDietPlan(String dietPlan_ID) {
	    for(DietPlan DietPlan : DietPlans) {
	    	if(DietPlan.getDietPlan_ID().equalsIgnoreCase(dietPlan_ID)) {
	    		int id =DietPlans.indexOf(DietPlan);
	    		DietPlans.remove(id);
	    		System.out.println("\n *** DietPlan Record deleted Successfully!  ***");
	    		return ;
	    	}
	    	else {
	    		System.out.println("\n*** Invalid DietPlan ID  ***");
	    	}
	    }
		
	}
	
	public void BMICalculator(double height,double weight){
		
		double bmi;
	    
			if (weight <= 0 || height <= 0) {
	            throw new IllegalArgumentException("\n*** Weight and height must be positive numbers.  ***");
	        }
			else {
				 bmi = ( 100 * 100 * weight ) / ( height * height );
				System.out.println("\nYour BMI : " + bmi);
			}
			
			 	if (bmi < 18.5) {
		            System.out.println("[ Underweight ]");
		        } else if (bmi >= 18.5 && bmi < 25) {
		        	System.out.println("[ Normal Weight ]");
		        } else if (bmi >= 25 && bmi < 30) {
		        	System.out.println("[ Overweight ]");
		        } else {
		        	System.out.println("[ Obese ]");
		        }
			
			System.out.println();
		   
	   }

	@Override
	public List<DietPlan> findBestDietPlan(String dp_bmiCategory) {
	    List<DietPlan> matchingDietPlans = new ArrayList<>();

	    // Iterate through all diet plans
	    for (DietPlan dietPlan : DietPlans) {
	        // Check if the BMI category matches the desired one
	        if (dietPlan.getDp_bmiCategory().equalsIgnoreCase(dp_bmiCategory)) {
	            matchingDietPlans.add(dietPlan);
	        }
	    }


	    return matchingDietPlans;
	}



	
	
}
