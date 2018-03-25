package com.song.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class ConfigController {
    
	
    //@Value("${server.port}")
	//@Value("${spring.application.name:application}")
	@Value("${democonfigclient.message}")
	String foo;
    
	@Value("${server.port}")
	String port;
	
	@RequestMapping(value = "/test")
    public String hi(){
        return foo;
    }
	
	/*	@RequestMapping(value = "/flush")
    public void refresh(){
		HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        headers.setContentType(type);
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        //params.add("", "");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
        RestTemplate restTemplate = new RestTemplate();
		
		//restTemplate.postForObject("http://localhost:"+ port + "/refresh", "", String.class);
		restTemplate.postForEntity("http://localhost:"+ port + "/refresh", requestEntity, String.class);
        return;
    }
	*/
	
}
