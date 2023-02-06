package com.springframework.fullstackapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class FullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackApplication.class, args);
	}

}
