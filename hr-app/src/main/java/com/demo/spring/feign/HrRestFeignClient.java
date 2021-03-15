package com.demo.spring.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="hr-app",url = "http://localhost:9090")
public interface HrRestFeignClient {

		
	@GetMapping(path="/hr/details", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<String> getEmpDetails(@RequestParam("id") int id,@RequestHeader("Accept") String accept);
	
	@GetMapping(path="/hr/all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String>> getAllEmps();
	
		
}
