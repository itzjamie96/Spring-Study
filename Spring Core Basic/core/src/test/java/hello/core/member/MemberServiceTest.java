package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
	
	// 1. 테스트할 서비스를 불러온다
	MemberService memberService = new MemberServiceImpl();
	
	// 2. @Test할 함수를 쓴다
	@Test
	void join() {
		//given : 이런 객체에 대해서
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		//when : 이런 상황이 주어졌을 때
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		//then : 이런 결과가 나오는지 검증하자
		Assertions.assertThat(member).isEqualTo(findMember);	//join한거랑 find하는거랑 같니?
		
		
	}
	
}
