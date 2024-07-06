package com.training.trainingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.trainingapp.DTO.WorkoutDTO;
import com.training.trainingapp.model.Workout;

@Mapper
public interface WorkoutMapper {
    WorkoutMapper INSTANCE = Mappers.getMapper(WorkoutMapper.class);

    WorkoutDTO workoutToWorkoutDTO(Workout workout);

    Workout workoutDtoToWorkout(WorkoutDTO workoutDTO);
}
