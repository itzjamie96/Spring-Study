package com.library.member.dao;

import java.util.HashMap;
import java.util.Map;

import com.library.member.Member;

public class MemberDao {
	
	private Map<String, Member> memberDB = new HashMap<String, Member>();
	
	public void insert(Member member) {
		memberDB.put(member.getId(), member);
	}
	
	public Member select(String id) {
		return memberDB.get(id);
	}
	
	public void update(Member member) {
		
	}
	public void delete(Member member) {
		
	}
	
	public Map<String, Member> getMemberDB() {
		return memberDB;
	}

}
