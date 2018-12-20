package com.qa.soph.springGarage1App;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringGarage1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringGarage1Application.class, args);
	}
}
