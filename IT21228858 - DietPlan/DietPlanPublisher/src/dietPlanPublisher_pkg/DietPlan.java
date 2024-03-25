package dietPlanPublisher_pkg;

public class DietPlan {

	private String dietPlan_ID;
	private String dietPlan_name;
	private String dp_weight;
	private String dp_height;	
	private String dietPlan;
	private String dietPlan_period;
	private String dp_bmiCategory;
	
	
	public DietPlan(String dietPlan_ID, String dietPlan_name, String dp_weight, String dp_height, String dietPlan,String dietPlan_period, String dp_bmiCategory) {
		super();
		this.dietPlan_ID = dietPlan_ID;
		this.dietPlan_name = dietPlan_name;
		this.dp_weight = dp_weight;
		this.dp_height = dp_height;
		this.dietPlan = dietPlan;
		this.dietPlan_period = dietPlan_period;
		this.dp_bmiCategory = dp_bmiCategory;
	}


	public String getDietPlan_ID() {
		return dietPlan_ID;
	}


	public void setDietPlan_ID(String dietPlan_ID) {
		this.dietPlan_ID = dietPlan_ID;
	}


	public String getDietPlan_name() {
		return dietPlan_name;
	}


	public void setDietPlan_name(String dietPlan_name) {
		this.dietPlan_name = dietPlan_name;
	}


	public String getDp_weight() {
		return dp_weight;
	}


	public void setDp_weight(String dp_weight) {
		this.dp_weight = dp_weight;
	}


	public String getDp_height() {
		return dp_height;
	}


	public void setDp_height(String dp_height) {
		this.dp_height = dp_height;
	}


	public String getDietPlan() {
		return dietPlan;
	}


	public void setDietPlan(String dietPlan) {
		this.dietPlan = dietPlan;
	}


	public String getDietPlan_period() {
		return dietPlan_period;
	}


	public void setDietPlan_period(String dietPlan_period) {
		this.dietPlan_period = dietPlan_period;
	}


	public String getDp_bmiCategory() {
		return dp_bmiCategory;
	}


	public void setDp_bmiCategory(String dp_bmiCategory) {
		this.dp_bmiCategory = dp_bmiCategory;
	}
	
	
	
	
	

}
