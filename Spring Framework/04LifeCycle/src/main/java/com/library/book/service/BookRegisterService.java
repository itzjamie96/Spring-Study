package com.library.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.book.Book;
import com.library.book.dao.BookDao;

public class BookRegisterService implements InitializingBean, DisposableBean{
	
	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() {  }
	
	public void register(Book book) {
		bookDao.insert(book);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("---BookRegisterService InitializingBean!---");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("---BookRegisterService DisposableBean!---");
		
	}

}
