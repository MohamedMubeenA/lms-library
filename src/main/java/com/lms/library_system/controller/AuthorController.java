package com.lms.library_system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lms.library_system.dto.AuthorBookRequest;
import com.lms.library_system.entity.Author;
import com.lms.library_system.response.ApiResponse;
import com.lms.library_system.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> saveAuthor(@RequestBody Author author) {
		ApiResponse apiResponse = new ApiResponse();
		Author savedResult = authorService.saveAuthor(author);
		apiResponse.setMessage("Author Created Successfully");
		apiResponse.setStatus(201);
		apiResponse.setData(savedResult);
		return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/getAllAuthors")
	public ResponseEntity<ApiResponse> getAllAuthors() {
		ApiResponse apiResponse = new ApiResponse();
		List<Author> allAuthors = authorService.getAllAuthors();
		apiResponse.setMessage("Author Data Received Successfully");
		apiResponse.setStatus(200);
		apiResponse.setData(allAuthors);
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/getAuthorById/{id}")
	public ResponseEntity<ApiResponse> getAuthorById(@PathVariable Long id){
		ApiResponse apiResponse = new ApiResponse();
		Optional<Author> authorById = authorService.getAuthorById(id);
		apiResponse.setMessage("Author Data Received Successfully");
		apiResponse.setStatus(200);
		apiResponse.setData(authorById);
		return ResponseEntity.ok(apiResponse);
	}
	
	@PutMapping("/updateAuthor/{id}")
	public ResponseEntity<ApiResponse> updateAuthorById(@PathVariable Long id, @RequestBody Author author){
		ApiResponse apiResponse = new ApiResponse();
		Author updatedAuthor = authorService.updateAuthor(id, author);
		apiResponse.setMessage("Author Data Received Successfully");
		apiResponse.setStatus(200);
		apiResponse.setData(updatedAuthor);
		return ResponseEntity.ok(apiResponse);
	}
	
	
	@PatchMapping("/patchUpdate/{id}")
	public ResponseEntity<ApiResponse> updateAuthorUsingPatch(@PathVariable Long id, @RequestBody Author author){
		ApiResponse apiResponse = new ApiResponse();
		Author patchUpdate = authorService.partialUpdate(id, author);
		apiResponse.setMessage("Author Data Updated Successfully");
		apiResponse.setStatus(200);
		apiResponse.setData(patchUpdate);
		return ResponseEntity.ok(apiResponse);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
		ApiResponse apiResponse = new ApiResponse();
		String output = authorService.deleteById(id);
		apiResponse.setMessage(output);
		apiResponse.setStatus(200);
		return ResponseEntity.ok(apiResponse);
	}

	@PostMapping("/saveAuthorWithBooks")
	public ResponseEntity<ApiResponse> saveAuthorWithBooks(@Valid @RequestBody AuthorBookRequest authorBookReq){
		ApiResponse apiResponse = new ApiResponse();
		Author savedAuthor = authorService.saveAuthorWithBooks(authorBookReq);
		apiResponse.setMessage("Author with Books Data Created Successfully");
		apiResponse.setStatus(201);
		apiResponse.setData(savedAuthor);
		return ResponseEntity.ok(apiResponse);
	}
}
