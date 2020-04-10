package com.example.firestore.demofirestore.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.firestore.demofirestore.entity.Person;
import com.example.firestore.demofirestore.service.PersonService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "Add a person to the person collection", notes =  "")
	@PostMapping("/")
	public Person addPerson(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return personService.add(person);
	}

	@ApiOperation(value = "Get a person by id", notes =  "")
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable("id") long id) throws InterruptedException, ExecutionException {
		return personService.get(id);
	}
	
	@ApiOperation(value = "Get all person", notes =  "")
	@GetMapping("/all")
	public List<Person> getAllPerson() throws InterruptedException, ExecutionException {
		return personService.getAll();
	}
}