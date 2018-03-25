package com.song.service.impl;

import org.springframework.stereotype.Service;

import com.song.service.FeignService;

@Service
public class FeignError implements FeignService {

	@Override
	public String error() {
		return "Feign Error!";
	}

}
