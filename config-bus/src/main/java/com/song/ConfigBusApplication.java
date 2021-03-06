package com.song;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigBusApplication.class, args);
	}
}
