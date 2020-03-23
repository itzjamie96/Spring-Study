package com.library.book.dao;

import java.util.HashMap;
import java.util.Map;

import com.library.book.Book;

public class BookDao {
	
	private Map<String, Book> bookDB = new HashMap<String, Book>();
	
	public void insert(Book book) {
		bookDB.put(book.getIsbn(), book);
	}
	
	public Book select(String isbn) {
		return bookDB.get(isbn);
	}
	
	public void update(Book book) {
		
	}
	
	public void delete() {
		
	}
	
	public Map<String, Book> getBookDB() {
		return bookDB;
	}
	

}
