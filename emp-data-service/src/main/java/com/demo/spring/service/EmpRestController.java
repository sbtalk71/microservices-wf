package com.demo.spring.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.ResponseMessage;
import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpRestController {

	@Autowired
	private EmpRepository repo;
	
	//@RequestMapping(path="/emp/find/{eid}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path="/emp/find/{eid}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity findEmpById(@PathVariable("eid") int id) {
		Optional<Emp> op=repo.findById(id);
		if(op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}else {
			throw new RuntimeException("Emp not Found");
		}
	}
	
	@GetMapping(path="/emp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAll() {
			return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping(path="/emp/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<ResponseMessage> saveEmp(@RequestBody @Valid Emp e){
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new ResponseMessage("EMP Exists","XXX"));
		}else {
		repo.save(e);
		return ResponseEntity.ok(new ResponseMessage("EMP Created","201"));
		}
	}
	
	@PutMapping(path="/emp/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMessage> updateEmp(@RequestBody @Valid Emp e){
		
		
		if(!repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new ResponseMessage("EMP NOT Found","404"));
		}else {
		repo.save(e);
		return ResponseEntity.ok(new ResponseMessage("EMP updated","200"));
		}
		
	}
	
	@DeleteMapping(path="/emp/delete",produces = MediaType.TEXT_PLAIN_VALUE)
		public ResponseEntity<String> deleteEmp(@RequestParam("id") int id){
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("Emp deleted with the given ID : "+id);
		}else {
			return ResponseEntity.ok("Emp not found with the given ID : "+id);
		}
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleEmpNotFound(RuntimeException e){
		return ResponseEntity.ok(new ResponseMessage("EMP NOT Found","404"));
	}
}
