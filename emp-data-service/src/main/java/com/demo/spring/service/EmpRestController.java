package com.demo.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpRestController {

	@Autowired
	private EmpRepository repo;
	
	//@RequestMapping(path="/emp/find/{eid}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path="/emp/find/{eid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmpById(@PathVariable("eid") int id) {
		Optional<Emp> op=repo.findById(id);
		if(op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(path="/emp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAll() {
			return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping(path="/emp/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e){
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Emp already exists with the given ID : "+e.getEmpId());
		}else {
		repo.save(e);
		return ResponseEntity.ok("Emp saved with the given ID : "+e.getEmpId());
		}
	}
}
