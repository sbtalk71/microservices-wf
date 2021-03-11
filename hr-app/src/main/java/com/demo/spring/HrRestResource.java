package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class HrRestResource {

	@Autowired
	RestTemplate rt;
	
	
	@GetMapping(path="/hr/details", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> getEmpDetails(@RequestParam("id") int id,@RequestHeader("Accept") String accept){
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", accept);
		
		HttpEntity reqEntity=new HttpEntity<>(headers);
		
		return rt.exchange("http://localhost:8181/emp/find/"+id, HttpMethod.GET, reqEntity, String.class);

	}
	
	@GetMapping(path="/hr/all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getAllEmps(){
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity reqEntity=new HttpEntity<>(headers);
		
		return rt.exchange("http://localhost:8181/emp", HttpMethod.GET, reqEntity, String.class);

	}
}
