package com.training.trainingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.trainingapp.DTO.UserDTO;
import com.training.trainingapp.mapper.UserMapper;
import com.training.trainingapp.model.UserEntity;
import com.training.trainingapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userEntity);
        return UserMapper.INSTANCE.userEntityToUserDTO(userEntity);
    }

    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
