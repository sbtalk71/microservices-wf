package com.demo.spring.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class RestClient1 {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		
		//ResponseEntity<String> resp= rt.getForEntity("http://localhost:8181/emp/find/104",String.class);
		
		//System.out.println(resp.getBody());
		
		//----------------------
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		
		HttpEntity reqEntity=new HttpEntity<>(headers);
		
		ResponseEntity<String> response2=rt.exchange("http://localhost:8181/emp/find/104", HttpMethod.GET, reqEntity, String.class);

		System.out.println(response2.getBody());
		
		ResponseEntity<Emp> response3=rt.exchange("http://localhost:8181/emp/find/104", HttpMethod.GET, reqEntity, Emp.class);

		System.out.println(response3.getBody().getName());
	}

}
