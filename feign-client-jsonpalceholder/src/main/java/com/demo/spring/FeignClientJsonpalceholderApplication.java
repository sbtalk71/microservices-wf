package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientJsonpalceholderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientJsonpalceholderApplication.class, args);
	}

}
