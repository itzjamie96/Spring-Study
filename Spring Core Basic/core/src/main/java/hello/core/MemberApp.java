package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

// 메인 메소드로 테스트를 하는건 한계가 있기 때문에 jUnit을 쓸 것이다
public class MemberApp {

	public static void main(String[] args) {
		
		// 서비스 불러오기 (구현체로 불러오기)
		MemberService memberService = new MemberServiceImpl();
		
		//회원 생성
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		// 회원 가입
		memberService.join(member);
		// 회원조회
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member = "+member.getName());
		System.out.println("find member = " + findMember.getName());
		
	}
}
