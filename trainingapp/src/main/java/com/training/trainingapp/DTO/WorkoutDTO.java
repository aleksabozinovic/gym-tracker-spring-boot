package com.training.trainingapp.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WorkoutDTO {
    private String workoutName;
    private LocalDate workoutDate;
    private List<ExerciseDTO> exercises = new ArrayList<>();

    // private String exerciseName;
    // // private String weight;
    // private String reps;
    // private String series;

}
