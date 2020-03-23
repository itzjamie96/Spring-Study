package com.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.library.book.dao.BookDao;
import com.library.book.service.BookRegisterService;
import com.library.book.service.BookSearchService;
import com.library.member.dao.MemberDao;
import com.library.member.service.MemberRegisterService;
import com.library.member.service.MemberSearchService;

@Configuration
public class LibraryConfig {

	@Bean
	public BookDao bookDao() {
		return new BookDao();
	}
	
	@Bean
	public BookRegisterService bookRegisterService() {
		return new BookRegisterService(bookDao());
	}
	
	@Bean
	public BookSearchService bookSearchService() {
		return new BookSearchService();
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}
	
	@Bean
	public MemberSearchService memberSearchService() {
		return new MemberSearchService();
	}
	
}
