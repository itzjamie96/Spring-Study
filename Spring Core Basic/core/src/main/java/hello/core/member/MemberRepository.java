package hello.core.member;

// 회원 저장소
public interface MemberRepository {
	
	// 회원 저장 (db에)
	void save(Member member);
	
	// 회원 조회 (db에서 꺼내서)
	Member findById(Long memberId);
}
