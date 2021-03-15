package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.clients.JSONPlaceHolderClient;
import com.demo.spring.model.Post;

@Component
public class TestClient implements CommandLineRunner {

	@Autowired
	JSONPlaceHolderClient client;
	
	@Override
	public void run(String... args) throws Exception {
		Post post=client.findPost(10);
		
		System.out.println(post.getBody());
		

	}

}
