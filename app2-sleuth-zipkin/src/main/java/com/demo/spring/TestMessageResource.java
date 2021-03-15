package com.demo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMessageResource {

	Logger LOGGER=LoggerFactory.getLogger(TestMessageResource.class);
	@GetMapping(path="/message")
	public String getMessage() {
		LOGGER.info("getMessage() returning message");
		return "Have a nice day!!";
	}
}
