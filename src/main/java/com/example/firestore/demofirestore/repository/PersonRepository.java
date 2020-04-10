package com.example.firestore.demofirestore.repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.firestore.demofirestore.entity.Person;

public interface PersonRepository {
	
	Person add(Person person) throws InterruptedException, ExecutionException;
	
	Person get(long id) throws InterruptedException, ExecutionException;
	
	Person delete(long id);
	
	List<Person> getAll() throws InterruptedException, ExecutionException;
}
