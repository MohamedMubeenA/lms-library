package com.lms.library_system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lms.library_system.entity.Book;
import com.lms.library_system.response.ApiResponse;
import com.lms.library_system.service.BookService;

@RestController
@RequestMapping("/v1/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/addBooks")
	public ResponseEntity<ApiResponse> addBook(@RequestBody Book book) {
		ApiResponse apiResponse = new ApiResponse();
		Book savedBooks = bookService.saveBook(book);
		apiResponse.setMessage("Book Added Successfully");
		apiResponse.setStatus(201);
		apiResponse.setData(savedBooks);
		return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/getBooks")
	public ResponseEntity<ApiResponse> getAllBooks() {
		ApiResponse apiResponse = new ApiResponse();
		List<Book> allBooks = bookService.getAllBooks();
		apiResponse.setMessage("Book Added Successfully");
		apiResponse.setStatus(201);
		apiResponse.setData(allBooks);
		return ResponseEntity.ok(apiResponse);
	}
}
