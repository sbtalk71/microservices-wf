package com.demo.spring.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.spring.model.Post;

@FeignClient(value = "jsonplaceholder",url = "https://jsonplaceholder.typicode.com")
public interface JSONPlaceHolderClient {

	@GetMapping(path="/posts/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Post findPost(@PathVariable("id") int id);
	
	@GetMapping(path="/posts",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Post> list();
}
