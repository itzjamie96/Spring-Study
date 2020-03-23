package com.library.book;

import com.library.member.Member;

public class Book {
	
	private String isbn;
	private String title;
	private boolean available;
	private Member member;
	
	public Book() { }

	public Book(String isbn, String title, boolean available, Member member) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.available = available;
		this.member = member;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	

}
