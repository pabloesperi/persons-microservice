package com.proyects.microservices.app.personsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PersonsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonsMicroserviceApplication.class, args);
	}

}
