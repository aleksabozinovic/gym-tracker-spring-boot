package com.training.trainingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.trainingapp.model.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, String> {
    List<Workout> findByUserId(String id);
}
