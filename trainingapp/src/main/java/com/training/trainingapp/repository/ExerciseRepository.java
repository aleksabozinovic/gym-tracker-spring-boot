package com.training.trainingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.trainingapp.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
    List<Exercise> findByWorkoutId(String workoutId);
}
