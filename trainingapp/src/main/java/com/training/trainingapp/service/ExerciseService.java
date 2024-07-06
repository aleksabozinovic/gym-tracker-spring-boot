package com.training.trainingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.trainingapp.model.Exercise;
import com.training.trainingapp.repository.ExerciseRepository;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
}
