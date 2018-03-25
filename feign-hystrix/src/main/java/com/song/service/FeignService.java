package com.song.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.song.service.impl.FeignError;

@FeignClient(value="eureka-client", fallback=FeignError.class)
public interface FeignService {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String error();
	
}
