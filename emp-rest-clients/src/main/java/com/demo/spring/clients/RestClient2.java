package com.demo.spring.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class RestClient2 {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		
				
		HttpHeaders headers=new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		
		
		Emp emp= new Emp(114, "Simran", "Noida", 78000);
		
		HttpEntity reqEntity=new HttpEntity<>(emp,headers);
		
				
		ResponseEntity<String> response3=rt.exchange("http://localhost:8181/emp/save", HttpMethod.POST, reqEntity,String.class);

		System.out.println(response3.getBody());
	}

}
