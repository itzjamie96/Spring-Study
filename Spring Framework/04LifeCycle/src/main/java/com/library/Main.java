package com.library;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.library.book.Book;
import com.library.book.service.BookRegisterService;
import com.library.book.service.BookSearchService;
import com.library.member.Member;
import com.library.member.service.MemberRegisterService;
import com.library.member.service.MemberSearchService;

public class Main {

	public static void main(String[] args) {
		String[] isbn = { "739", "985", "184", "830", "816" };
		String[] title = { "html", "css", "jQuery", "java", "spring" };
		
		String[] id = { "rabbit", "hippo", "raccoon", "elephan", "lion" };
		String[] pw = { "96539", "94875", "15284", "48765", "28661" };
		String[] name = { "agatha", "barbara", "chris", "doris", "elva" };
		
		GenericXmlApplicationContext xml = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//도서 목록 등록
		BookRegisterService bookRegisterService = xml.getBean("bookRegisterService", BookRegisterService.class);
		
		for(int i=0; i<isbn.length; i++) {
			Book book = new Book(isbn[i], title[i], true, null);
			bookRegisterService.register(book);
		}
		
		//도서 목록 출력
		BookSearchService bookSearchService = xml.getBean("bookSearchService", BookSearchService.class);
		
		System.out.println("isbn\tTitle\tavailable?\tmember");
		System.out.println("------------------------------------------");
		
		for(int i=0; i<isbn.length; i++) {
			Book book = bookSearchService.searchBook(isbn[i]);
			System.out.print(book.getIsbn()+ "\t");
			System.out.print(book.getTitle()+ "\t");
			System.out.print(book.isAvailable()+ "\t"+ "\t");
			
			//빌려간 사람 확인하기
			//null인지? True = Null / False = getName
			System.out.println(book.getMember()==null ? null:book.getMember().getName());
		}
		
		
		//회원 등록
		MemberRegisterService memberRegisterService = xml.getBean("memberRegisterService", MemberRegisterService.class);
		
		for (int i=0; i<id.length; i++) {
			Member member = new Member(id[i], pw[i], name[i]);
			memberRegisterService.register(member);
		}
		
		//회원 목록 출력
		MemberSearchService memberSearchService = xml.getBean("memberSearchService", MemberSearchService.class);
		
		System.out.println();
		System.out.println("Name\tid\tpw");
		System.out.println("------------------------------------------");
		
		for(int i=0; i<id.length;i++) {
			Member member = memberSearchService.searchMember(id[i]);
			
			System.out.print(member.getName() +"\t");
			System.out.print(member.getId() +"\t");
			System.out.print(member.getPw() +"\n");
		}
		
		
		//빌린 도서 등록
		bookRegisterService.register(new Book("739", "html", false, memberSearchService.searchMember("elephan")));
		bookRegisterService.register(new Book("184", "jQuery", false, memberSearchService.searchMember("hippo")));
		bookRegisterService.register(new Book("816", "spring", false, memberSearchService.searchMember("rabbit")));
		bookRegisterService.register(new Book("985", "css", false, memberSearchService.searchMember("rabbit")));
		
		//다시 책 목록
		System.out.println("\n***Check library status***");
		System.out.println("isbn\tTitle\tavailable?\tmember");
		System.out.println("------------------------------------------");
		
		for(int i=0; i<isbn.length; i++) {
			Book book = bookSearchService.searchBook(isbn[i]);
			System.out.print(book.getIsbn()+ "\t");
			System.out.print(book.getTitle()+ "\t");
			System.out.print(book.isAvailable()+ "\t"+ "\t");
			
			//빌려간 사람 확인하기
			//null인지? True = Null / False = getName
			System.out.println(book.getMember()==null ? null:book.getMember().getName());
		}
		
		xml.close();

	}

}
