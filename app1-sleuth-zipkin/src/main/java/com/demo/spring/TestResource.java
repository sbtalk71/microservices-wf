package com.demo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestResource {
	Logger LOGGER=LoggerFactory.getLogger(TestResource.class);
	@GetMapping(path="/greet")
	public String greet() {
		RestTemplate rt= new RestTemplate();
		LOGGER.info("in greet method ");
		return "Good Morning"+", "+rt.getForObject("http://localhost:8282/message", String.class);
	}
}
