package com.example;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAngularDemoApplication {
	
	public static final Date startTime = new Date();

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularDemoApplication.class, args);
	}
}
