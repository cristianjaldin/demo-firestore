package com.example.firestore.demofirestore.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firestore.demofirestore.entity.Person;
import com.example.firestore.demofirestore.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person add(Person person) throws InterruptedException, ExecutionException {
		return personRepository.add(person);
	}

	@Override
	public Person get(long id) throws InterruptedException, ExecutionException {
		return personRepository.get(id);
	}

	@Override
	public Person delete(long id) {
		return personRepository.delete(id);
	}

	@Override
	public List<Person> getAll() throws InterruptedException, ExecutionException {
		return personRepository.getAll();
	}

}
