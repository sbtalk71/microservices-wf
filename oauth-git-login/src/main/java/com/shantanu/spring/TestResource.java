package com.shantanu.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

	@GetMapping("/test")
	public String message() {
		return "test1 working";
	}
	
	@GetMapping("/test2")
	public String message2() {
		return "test2 working";
	}
}
