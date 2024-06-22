package com.training.trainingapp.DTO;

import java.util.UUID;

import lombok.Data;

@Data
public class RegisterDTO {
    private UUID id;
    private String username;
    private String password;

    private String email;
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // private Date birthDate;
    private String name;
    private String lastName;
}
