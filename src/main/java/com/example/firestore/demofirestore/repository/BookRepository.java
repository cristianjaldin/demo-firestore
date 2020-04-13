package com.example.firestore.demofirestore.repository;

import com.example.firestore.demofirestore.entity.Book;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface BookRepository extends FirestoreReactiveRepository<Book> {
	
}