package com.example.firestore.demofirestore.controller;

import java.util.List;

import com.example.firestore.demofirestore.entity.Book;
import com.example.firestore.demofirestore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
	private BookService bookService;
	
	@ApiOperation(value = "Add a Book to the books collection", notes =  "")
	@PostMapping("/")
	public Book addBook(@RequestBody Book book) {
		return bookService.add(book);
	}

	@ApiOperation(value = "Get a book by id", notes =  "")
	@GetMapping("/{id}")
	public Book getBook(@PathVariable("id") String id) {
		return bookService.get(id);
	}
	
	@ApiOperation(value = "Get all books", notes =  "")
	@GetMapping("/all")
	public List<Book> getAllBook() {
		return bookService.getAll();
	}

}