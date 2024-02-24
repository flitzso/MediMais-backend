package com.medimais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MedimaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedimaisApplication.class, args);
	}

}
