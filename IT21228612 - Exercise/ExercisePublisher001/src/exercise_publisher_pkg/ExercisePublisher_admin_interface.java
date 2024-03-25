package exercise_publisher_pkg;
import java.util.ArrayList;
import java.util.List;

public interface ExercisePublisher_admin_interface {
	
	
	
	public List <Exercise> getAllExercises();
	
	public void deleteExercise(String exercise_ID);

	public String addExercise(String exerciseID, String name, String muscle, int time_span, String goal);
	
	public void exportExercisesToCSV(String filePath) ;
	

	
	public List <Exercise> getExercisesByMuscle_customer(String muscle) ;
	public List <Exercise> generateExerciseSchedule_customer(ArrayList<String> goals) ;


}
