package com.lms.library_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.library_system.entity.Author;
import com.lms.library_system.service.AuthorService;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/create")
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
		Author savedResult = authorService.saveAuthor(author);
		return ResponseEntity.ok(savedResult);
	}

	@GetMapping("/getAllAuthors")
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> allAuthors = authorService.getAllAuthors();
		return ResponseEntity.ok(allAuthors);
	}
	
	@GetMapping("/getAuthorById/{id}")
	public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long id){
		Optional<Author> authorById = authorService.getAuthorById(id);
		return ResponseEntity.ok(authorById);
	}

}
