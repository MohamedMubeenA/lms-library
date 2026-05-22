package com.lms.library_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.library_system.entity.Author;
import com.lms.library_system.service.AuthorService;

@RestController
@RequestMapping("/v1")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;

	@PostMapping("/author/create")
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
		Author savedResult = authorService.saveAuthor(author);
		return ResponseEntity.ok(savedResult);
	}
}
