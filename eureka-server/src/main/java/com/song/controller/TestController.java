package com.song.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"classpath:application.yml"})
public class TestController {

	@Value("${spring.application.name}")
	private String appName;
	
	@RequestMapping("/test")
	public String test() {
		return appName;
	}

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/service/{name}")
	public List<ServiceInstance> serviceUrl(@PathVariable("name") String serviceName) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		return instances;
	}
	
	@GetMapping("/services")
	public List<String> services(String serviceName) {
		List<String> services = discoveryClient.getServices();
		return services;
	}

	
	
}
