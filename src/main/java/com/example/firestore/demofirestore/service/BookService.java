package com.example.firestore.demofirestore.service;

import java.util.List;

import com.example.firestore.demofirestore.entity.Book;

public interface BookService {
    Book add(Book book);
	Book get(String id);
	void delete(String id);
	List<Book> getAll();
}