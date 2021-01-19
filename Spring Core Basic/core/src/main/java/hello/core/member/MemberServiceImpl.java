package hello.core.member;

public class MemberServiceImpl implements MemberService{
	
	//회원 저장소 [역할]이 필요 => 역할을 구현한 구현체로 생성
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	@Override
	public void join(Member member) {
		//저장소의 save함수를 이용해 회원 가입(저장)
		memberRepository.save(member);
		
	}

	@Override
	public Member findMember(Long memberId) {
		// 저장소의 findById함수를 이용해서 회원 조회
		return memberRepository.findById(memberId);
	}
	
}
