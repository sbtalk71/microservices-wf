package com.demo.spring.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class TestController {

	@RequestMapping(path="/info",method = RequestMethod.GET,produces = "application/json")
	public String info() {
		return "{\"message\":\"this is info\"}";
	}
}
