package com.training.trainingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.trainingapp.DTO.ExerciseDTO;
import com.training.trainingapp.model.Exercise;

@Mapper
public interface ExerciseMapper {
    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);

    ExerciseDTO exerciseToExerciseDTO(Exercise exercise);

    Exercise exerciseDtoToExercise(ExerciseDTO exerciseDTO);
}
