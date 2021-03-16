package com.shantanu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String test() {
		//RestTemplate rt= new RestTemplate();
		//return rt.getForObject("http://localhost:9091/test2", String.class);
		return "The app is now working!!";
	}
}
