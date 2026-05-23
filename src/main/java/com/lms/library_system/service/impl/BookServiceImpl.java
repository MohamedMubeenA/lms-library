package com.lms.library_system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lms.library_system.entity.Book;
import com.lms.library_system.repository.BookRepository;
import com.lms.library_system.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book saveBook(Book book) {
		Book savedBook = bookRepo.save(book);
		return savedBook;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = bookRepo.findAll();
		return allBooks;
	}
}
