package com.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class RibbonService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="ribbonError")
	public String ribbon() {
//		return restTemplate.getForObject("http://eurekaClient/test", String.class);
		
		return restTemplate.getForObject("http://EUREKA-CLIENT/test", String.class);
		
	}

	public String ribbonError() {
		return "Ribbon Error!";
	}
	
}
