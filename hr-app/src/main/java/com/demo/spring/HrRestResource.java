package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class HrRestResource {

	@Autowired
	RestTemplate rt;
	
	
	@GetMapping(path="/hr/details", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> getEmpDetails(@RequestParam("id") int id,@RequestHeader("Accept") String accept){
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", accept);
		
		HttpEntity reqEntity=new HttpEntity<>(headers);
		
		return rt.exchange("http://emp-data-service/emp/find/"+id, HttpMethod.GET, reqEntity, String.class);

	}
	
	@GetMapping(path="/hr/all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getAllEmps(){
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity reqEntity=new HttpEntity<>(headers);
		
		return rt.exchange("http://emp-data-service/emp", HttpMethod.GET, reqEntity, String.class);

	}
	
		@GetMapping("/hr/test")
		@HystrixCommand(fallbackMethod = "fallbackTestServer")
		public ResponseEntity testServer() {
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		
		HttpEntity reqEntity=new HttpEntity<>(headers);
		
		return rt.exchange("http://emp-data-service/testload", HttpMethod.GET, reqEntity, String.class);

	}
		
		public ResponseEntity fallbackTestServer() {
			return ResponseEntity.ok("fallback message: Service unavailable try after sometime..");
		}
}
