package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 회원 찾기

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 할인 정책(고정)

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원정보 조회
        int discountPrice = discountPolicy
                .discount(member, itemPrice); // 할인 정책에 회원을 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
