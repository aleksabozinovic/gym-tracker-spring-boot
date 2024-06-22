package com.training.trainingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.trainingapp.DTO.UserDTO;
import com.training.trainingapp.model.UserEntity;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userEntityToUserDTO(UserEntity userEntity);

    UserEntity userDtoToUserEntity(UserDTO userDTO);
}