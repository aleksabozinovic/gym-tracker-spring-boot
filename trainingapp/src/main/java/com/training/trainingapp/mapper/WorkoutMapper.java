package com.training.trainingapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.trainingapp.DTO.WorkoutDTO;
import com.training.trainingapp.model.Workout;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {
    WorkoutMapper INSTANCE = Mappers.getMapper(WorkoutMapper.class);

    WorkoutDTO workoutToWorkoutDTO(Workout workout);

    Workout workoutDtoToWorkout(WorkoutDTO workoutDTO);

    List<WorkoutDTO> workoutToWorkoutDTO(List<Workout> byUserId);
}
