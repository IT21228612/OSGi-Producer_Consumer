package exercise_publisher_pkg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExercisePublisher_Impl implements ExercisePublisher_admin_interface {

    private List<Exercise> exerciseLists = new ArrayList<>();

    // Implement  interface methods

    @Override
    public String addExercise(String exerciseID, String name, String muscle, int time_span, String goal) {
        Exercise ex1 = new Exercise(exerciseID, name, muscle, time_span, goal);
        exerciseLists.add(ex1);
        return "***Exercise " + ex1.getExerciseID() + " Added Successfully! ***";
    }

    @Override
    public List<Exercise> getAllExercises() {
        return exerciseLists;
    }

    @Override
    public void deleteExercise(String ID) {
        boolean exerciseRemoved = exerciseLists.removeIf(ex -> ex.getExerciseID().equalsIgnoreCase(ID));

        if (exerciseRemoved) {
            System.out.println("Exercise " + ID + " Deleted Successfully");
        } else {
            System.out.println("Can not delete : Exercise with ID " + ID + " not found");
        }
    }
    
    
    
 // Export exercises to CSV file
    public void exportExercisesToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write CSV header
            writer.append("ExerciseID,Name,Muscle,TimeSpan,Goal\n");

            // Write each exercise as a CSV record
            for (Exercise exercise : exerciseLists) {
                writer.append(exercise.getExerciseID())
                      .append(",")
                      .append(exercise.getExerciseName())
                      .append(",")
                      .append(exercise.getExerciseMuscle())
                      .append(",")
                      .append(String.valueOf(exercise.getExerciseTimeSpan()))
                      .append(",")
                      .append(exercise.getGoal())
                      .append("\n");
            }
            System.out.println("Exercises exported to CSV file: " + filePath +"\n\n");
        } catch (IOException e) {
            System.err.println("Error exporting exercises to CSV: " + e.getMessage());
        }
    }



    

  

    @Override
    public List<Exercise> getExercisesByMuscle_customer(String muscle) {
        List<Exercise> exercisesByMuscle = new ArrayList<>();
        for (Exercise ex : exerciseLists) {
            if (ex.getExerciseMuscle().equalsIgnoreCase(muscle)) {
                exercisesByMuscle.add(ex);
            }
        }
        return exercisesByMuscle;
    }

    @Override
    public List<Exercise> generateExerciseSchedule_customer(ArrayList<String> goals) {
        List<Exercise> exerciseSchedule = new ArrayList<>();
        for (String goal : goals) {
            for (Exercise ex : exerciseLists) {
                if (ex.getGoal().equalsIgnoreCase(goal)) {
                    exerciseSchedule.add(ex);
                }
            }
        }
        return exerciseSchedule;
    }
}
