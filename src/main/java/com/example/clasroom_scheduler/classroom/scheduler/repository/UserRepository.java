package com.example.clasroom_scheduler.classroom.scheduler.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clasroom_scheduler.classroom.scheduler.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
