package com.library.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.member.Member;
import com.library.member.dao.MemberDao;

public class MemberSearchService {
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberSearchService() {  }
	
	public Member searchMember(String id) {
		return memberDao.select(id);
	}
	public void initMethod() {
		System.out.println("@@@MemberSearchService initMethod@@@");
	}
	public void destroyMethod() {
		System.out.println("@@@MemberSearchService destroyMethod@@@");
	}
}
