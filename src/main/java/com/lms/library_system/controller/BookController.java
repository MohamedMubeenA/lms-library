package com.lms.library_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lms.library_system.entity.Book;
import com.lms.library_system.service.BookService;

@RestController
@RequestMapping("/v1/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/addBooks")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedBooks = bookService.saveBook(book);
		return ResponseEntity.ok(savedBooks);
	}

	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> allBooks = bookService.getAllBooks();
		return ResponseEntity.ok(allBooks);
	}
	
	
}
