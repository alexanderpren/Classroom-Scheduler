package com.example.clasroom_scheduler.classroom.scheduler;

import org.springframework.boot.SpringApplication;

public class TestClassroomSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.from(ClassroomSchedulerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
