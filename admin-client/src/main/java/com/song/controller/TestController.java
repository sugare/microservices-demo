package com.song.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"classpath:application.yml"})
public class TestController {

	@Value("${spring.boot.admin.url}")
	private String url;
	
	@GetMapping("/test")
	public String url() {
		return url;
	}
	
}
