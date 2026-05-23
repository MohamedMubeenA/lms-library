package com.lms.library_system.service;

import java.util.List;
import java.util.Optional;

import com.lms.library_system.dto.AuthorBookRequest;
import com.lms.library_system.entity.Author;

public interface AuthorService {
	Author saveAuthor(Author author);

	List<Author> getAllAuthors();

	Optional<Author> getAuthorById(Long id);

	Author updateAuthor(Long id, Author author);
	
	Author partialUpdate(Long id, Author author);
	
	String deleteById(Long id);
	
	Author saveAuthorWithBooks(AuthorBookRequest authorBookReq);
}
