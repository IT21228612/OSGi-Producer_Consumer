package exercise_publisher_pkg;

public class Exercise {

	private String exerciseID;
	private String name;
	private String muscle;
	private String goal;
	private int time_span;
	
	public Exercise(String exerciseID,String name, String muscle, int timeSpan , String goal) {
		super();
		this.exerciseID = exerciseID;
		this.name = name;
		this.muscle = muscle;
		this.time_span = timeSpan;
		this.goal = goal;
	}
	
	
	
	public String getExerciseID() {
		return exerciseID;
	}
	
	public String getExerciseName() {
		return name;
	}

	public String getExerciseMuscle() {
		return muscle;
	}
	public int getExerciseTimeSpan() {
		return time_span;
	}
	
	
	
	public void setExerciseID(String exerciseID) {
		this.exerciseID = exerciseID;
	}
	
	public void setExerciseName(String name) {
		this.name = name;
	}
	
	public void setExerciseMuscle(String muscle) {
		this.muscle = muscle;
	}
	public void setExerciseTimeSpan(int time_span) {
		this.time_span = time_span;
	}



	public String getGoal() {
		return goal;
	}



	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	


	


}
