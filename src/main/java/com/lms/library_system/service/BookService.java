package com.lms.library_system.service;

import java.util.List;
import com.lms.library_system.entity.Book;

public interface BookService {
	Book saveBook(Book book);

	List<Book> getAllBooks();
}
