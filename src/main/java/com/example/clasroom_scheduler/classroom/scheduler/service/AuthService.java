package com.example.clasroom_scheduler.classroom.scheduler.service;

import com.example.clasroom_scheduler.classroom.scheduler.config.JwtTokenProvider;
import com.example.clasroom_scheduler.classroom.scheduler.dto.AuthRequest;
import com.example.clasroom_scheduler.classroom.scheduler.dto.AuthResponse;
import com.example.clasroom_scheduler.classroom.scheduler.dto.RegisterRequest;
import com.example.clasroom_scheduler.classroom.scheduler.entity.User;
import com.example.clasroom_scheduler.classroom.scheduler.enums.Role;
import com.example.clasroom_scheduler.classroom.scheduler.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    /**
     * Authenticates a user and returns an authentication token.
     *
     * @param authRequest the authentication request containing username and
     *                    password
     * @return AuthResponse containing the JWT token
     */

    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()));

        String token = jwtTokenProvider.generateToken(authentication);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        // check if the username already exists
        System.out.println("RegisterRequest recibido: " + registerRequest);
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        if (registerRequest.getPassword() == null) {
        throw new IllegalArgumentException("Password cannot be null");
    }

        // create a new user entity
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.ROLE_USER); // Por defecto rol USER

        // save the user to the database
        userRepository.save(user);

        //¿authenticate the user and generate a token?
        // This step is optional, depending on your requirements
        // If you want to log in the user immediately after registration:
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerRequest.getUsername(),
                        registerRequest.getPassword()));

        String token = jwtTokenProvider.generateToken(authentication);
        return new AuthResponse(token);
    }
}