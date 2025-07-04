package com.example.clasroom_scheduler.classroom.scheduler.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
 @GetMapping("/")
    public String home() {
        return "API Classroom Scheduler running!";
    }
}
