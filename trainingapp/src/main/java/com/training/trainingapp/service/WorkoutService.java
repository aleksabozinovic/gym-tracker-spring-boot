package com.training.trainingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.trainingapp.model.Workout;
import com.training.trainingapp.repository.ExerciseRepository;
import com.training.trainingapp.repository.WorkoutRepository;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Workout> findWorkoutsByUserId(String id) {
        // return List < Workout > workoutRepository.findAll();
        return workoutRepository.findByUserId(id);
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

}
