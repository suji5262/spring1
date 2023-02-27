package hello.core.discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount; // vip 면 1000원 할일
        } else {
            return 0; // 아니면 x
        }
    }


}
