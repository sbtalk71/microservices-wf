package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class TestResource {

	@GetMapping("/test")
	public String test() {
		return "You accessed a secured resource";
	}
}
