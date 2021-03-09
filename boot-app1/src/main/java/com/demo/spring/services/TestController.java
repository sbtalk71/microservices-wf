package com.demo.spring.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class TestController {

	@RequestMapping(path="/info",method = RequestMethod.GET)
	public String info() {
		return "This is a demo rest service";
	}
}
