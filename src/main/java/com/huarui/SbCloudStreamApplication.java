package com.huarui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCloudStreamApplication.class, args);
	}

}
