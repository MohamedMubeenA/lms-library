package com.lms.library_system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.library_system.dto.AuthorBookRequest;
import com.lms.library_system.entity.Author;
import com.lms.library_system.entity.Book;
import com.lms.library_system.repository.AuthorRepository;
import com.lms.library_system.repository.BookRepository;
import com.lms.library_system.service.AuthorService;

import jakarta.transaction.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	@Autowired
	private BookRepository bookRepo;

	@Override
	public Author saveAuthor(Author author) {
		System.out.println("Name:" + author.getName());
		return authorRepo.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();

	}

	@Override
	public Optional<Author> getAuthorById(Long id) {
		return authorRepo.findById(id);
	}

	@Override
	public Author updateAuthor(Long id, Author author) {
		Author existingData = authorRepo.findById(id).orElseThrow();
		existingData.setName(author.getName());
		existingData.setMail(author.getMail());
		return authorRepo.save(existingData);
	}

	@Override
	public Author partialUpdate(Long id, Author incomingFields) {
		Author existingData = authorRepo.findById(id).orElseThrow();
		if (incomingFields.getName() != null) {
			existingData.setName(incomingFields.getName());
		}
		if (incomingFields.getMail() != null) {
			existingData.setMail(incomingFields.getMail());
		}
		return authorRepo.save(existingData);
	}

	@Override
	public String deleteById(Long id) {
		Optional<Author> author = authorRepo.findById(id);
		if (author.isPresent()) {
			authorRepo.deleteById(id);
			return "Author " + id + " : Deleted Succesfully";
		} else {
			return "Id does not exist";
		}
	}

	@Transactional
	@Override
	public Author saveAuthorWithBooks(AuthorBookRequest authorBookReq) {
		Author author = new Author();
		author.setName(authorBookReq.getName());
		author.setMail(authorBookReq.getMail());
		Author savedAuthor = authorRepo.save(author); //Like author_id generation, after save
		List<Book> dtoBooks = authorBookReq.getBooks();
		for(Book book : dtoBooks) {
			book.setAuthor(savedAuthor);
			savedAuthor.setBooks(dtoBooks);
			bookRepo.save(book);
		}    
	    return savedAuthor;
	}
}
