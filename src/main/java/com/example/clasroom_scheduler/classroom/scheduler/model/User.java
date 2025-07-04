package com.example.clasroom_scheduler.classroom.scheduler.model;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled = true;

    @ElementCollection(fetch = jakarta.persistence.FetchType.EAGER)
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private Set<Role> roles;


}
