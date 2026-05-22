package com.lms.library_system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.library_system.entity.Author;
import com.lms.library_system.repository.AuthorRepository;
import com.lms.library_system.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepo;

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
	if(incomingFields.getName() != null) {
		existingData.setName(incomingFields.getName());
	}
	if(incomingFields.getMail() != null) {
		existingData.setMail(incomingFields.getMail());
	}
    return authorRepo.save(existingData);
	}

}
