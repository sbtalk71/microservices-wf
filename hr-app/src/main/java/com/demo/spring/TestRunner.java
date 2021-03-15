package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.feign.HrRestFeignClient;

//@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	HrRestFeignClient client;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(client.getEmpDetails(104, "application/json"));
		
		//client.getAllEmps().getBody().forEach(System.out::println);

	}

}
