package com.lms.library_system.dto;

import java.util.List;
import com.lms.library_system.entity.Book;

public class AuthorBookRequest {
	private String name;
	private String mail;
	private List<Book> books;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
