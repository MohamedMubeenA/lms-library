package com.lms.library_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.library_system.entity.Author;
import com.lms.library_system.repository.AuthorRepository;
import com.lms.library_system.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepo;

	@Override
	public Author saveAuthor(Author author) {
		System.out.println("Name:" + author.getName());
		return authorRepo.save(author);
	}

}
