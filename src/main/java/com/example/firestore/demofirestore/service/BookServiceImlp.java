package com.example.firestore.demofirestore.service;

import java.util.List;

import com.example.firestore.demofirestore.entity.Book;
import com.example.firestore.demofirestore.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImlp implements BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Override
	public Book add(Book book){
        return bookRepository.save(book).block();
    }
    
    @Override
	public Book get(String id) {
		return bookRepository.findById(id).block();
	}

    @Override
	public void delete(String id) {
        bookRepository.deleteById(id);
	}

    @Override
	public List<Book> getAll() {
		return bookRepository.findAll().collectList().block();
	}
    
}