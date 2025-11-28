package com.example.deer.ApplicationDevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.deer", "com.example.service"})
public class ApplicationDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDevelopmentApplication.class, args);
	}

}
