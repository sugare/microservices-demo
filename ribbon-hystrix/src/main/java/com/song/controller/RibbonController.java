package com.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.service.RibbonService;

@RestController
@PropertySource({"classpath:application.yml"})
public class RibbonController {

	@Autowired
	private RibbonService ribbonService;
	
	@Value("${eureka.instance.instanceId}")
	private String instanceId;
	
	
	@GetMapping("/test")
	public String test() {
		return instanceId;
	}
	
	@GetMapping("/ribbon")
	public String ribbon() {
		return ribbonService.ribbon();
	}
	
}
