package com.example.clasroom_scheduler.classroom.scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clasroom_scheduler.classroom.scheduler.dto.AuthRequest;
import com.example.clasroom_scheduler.classroom.scheduler.dto.AuthResponse;
import com.example.clasroom_scheduler.classroom.scheduler.dto.RegisterRequest;
import com.example.clasroom_scheduler.classroom.scheduler.service.AuthService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authService.login(authRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        System.out.println("RegisterRequest recibido: " + registerRequest);
        System.out.println("Username recibido: " + registerRequest.getUsername());
        System.out.println("Password recibido: " + registerRequest.getPassword());
        AuthResponse authResponse = authService.register(registerRequest);

        return ResponseEntity.ok(authResponse);
    }

}
