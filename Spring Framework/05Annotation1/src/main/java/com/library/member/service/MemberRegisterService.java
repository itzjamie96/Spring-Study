package com.library.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.member.Member;
import com.library.member.dao.MemberDao;

public class MemberRegisterService {
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { }
	
	public void register(Member member) {
		memberDao.insert(member);
	}
	
	public void initMethod() {
		System.out.println("@@@MemberRegisterService initMethod@@@");
	}
	public void destroyMethod() {
		System.out.println("@@@MemberRegisterService destroyMethod@@@");
	}

}
