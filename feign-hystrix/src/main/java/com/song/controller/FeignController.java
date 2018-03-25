package com.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.service.FeignService;

@RestController
@PropertySource({"classpath:application.yml"})
public class FeignController {

	@Autowired
	private FeignService feignService;
	
	@Value("${eureka.instance.instanceId}")
	private String instanceId;
	
	
	@GetMapping("/test")
	public String test() {
		return instanceId;
	}
	
	@GetMapping("/feign")
	public String feign() {
		return feignService.error();
	}
	
	
}
