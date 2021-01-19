package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	// 회원의 등급 조회용
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	// 할인정책 적용여부 확인용
	private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// 회원을 조회한다
		Member member = memberRepository.findById(memberId);
		
		//단일 책임 적용: 주문은 주문 생성만, 할인률 확인은 discountPolicy가 in charge
		// 찾은 회원을 넘겨서 할인률 확인
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		//할인률 적용된 주문 생성 후 리턴
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	

}
