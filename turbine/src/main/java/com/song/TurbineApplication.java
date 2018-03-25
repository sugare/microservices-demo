package com.song;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class TurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}
