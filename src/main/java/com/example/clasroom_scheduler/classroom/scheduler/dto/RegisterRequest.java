package com.example.clasroom_scheduler.classroom.scheduler.dto;

import com.example.clasroom_scheduler.classroom.scheduler.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterRequest {
    @NotBlank
    private String username;

    private String email;
    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    private Role role;
}
