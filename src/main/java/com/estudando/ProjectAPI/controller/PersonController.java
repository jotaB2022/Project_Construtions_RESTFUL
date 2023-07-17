package com.estudando.ProjectAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudando.ProjectAPI.dto.PersonVO;
import com.estudando.ProjectAPI.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService service;
	
	
	@GetMapping
	public List<PersonVO> findAll(){
	
		return service.findAll();
	}
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {
	
		return service.create(person);
				
	}
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@PutMapping("/{id}")
	public PersonVO update(@RequestBody PersonVO person){
		return service.update(person);
}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
}
