package com.library.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.book.Book;
import com.library.book.dao.BookDao;

public class BookSearchService implements InitializingBean, DisposableBean{

	@Autowired
	private BookDao bookDao;
	
	public BookSearchService() {  }
	
	public Book searchBook(String isbn) {
		return bookDao.select(isbn);
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("---BookSearchService InitializingBean!---");
		
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("---BookSearchService DisposableBean!---");		
	}
}
