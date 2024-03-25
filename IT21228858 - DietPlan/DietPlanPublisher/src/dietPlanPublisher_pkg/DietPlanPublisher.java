package dietPlanPublisher_pkg;
import java.util.List;

public interface DietPlanPublisher {
	
	public String addDietPlan(String dietPlan_ID, String dietPlan_name, String dp_weight, String dp_height, String dietPlan,String dietPlan_period, String dp_bmiCategory);
	public void deleteDietPlan(String dietPlan_ID);
	public List<DietPlan> getAllDietPlan();
	public void BMICalculator(double height, double weight);
	public List<DietPlan> findBestDietPlan(String dp_bmiCategory);
}
