package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{
	
	//1000원 할인
	private int fixedDiscountAmount = 1000;

	@Override
	public int discount(Member member, int price) {
		//등급이 vip라면 할인금액 리턴
		if (member.getGrade() == Grade.VIP) {
			return fixedDiscountAmount;
		} else {
			return 0;			
		}
	}



}
