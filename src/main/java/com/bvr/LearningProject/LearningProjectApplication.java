package com.bvr.LearningProject;

import com.bvr.helper.Loging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningProjectApplication {
	private static final Loging log = Loging.getInstance(LearningProjectApplication.class);
	public static void main(String[] args) {
		log.flow("Start");
		SpringApplication.run(LearningProjectApplication.class, args);
		log.init("=========================Server started successfully===================");
	}

}
