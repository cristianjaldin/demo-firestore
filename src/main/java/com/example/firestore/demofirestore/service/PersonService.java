package com.example.firestore.demofirestore.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.firestore.demofirestore.entity.Person;

public interface PersonService {
	
	Person add(Person person) throws InterruptedException, ExecutionException;
	
	Person get(long id) throws InterruptedException, ExecutionException;
	
	Person delete(long id);
	
	List<Person> getAll() throws InterruptedException, ExecutionException;
	
}