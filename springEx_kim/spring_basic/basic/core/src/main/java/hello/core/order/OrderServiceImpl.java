package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    private final MemberRepository memberRepository;
//    // 회원 찾기
//    private final DiscountPolicy discountPolicy;

//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    // 할인 정책(고정)

//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy
//            discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    } // 일반 메서드 주입


//    @Autowired
//    public OrderServiceImpl(
//            MemberRepository memberRepository,
//            DiscountPolicy discountPolicy) { // 생성자 주입
////        System.out.println("memberRepository = " + memberRepository);
////        System.out.println("discountPolicy = " + discountPolicy);
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

//    @Autowired
//    public OrderServiceImpl(
//            MemberRepository memberRepository,
//            @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
////        System.out.println("memberRepository = " + memberRepository);
////        System.out.println("discountPolicy = " + discountPolicy);
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    } // @Qualifier


    @Autowired
    public OrderServiceImpl(
            MemberRepository memberRepository,
            @MainDiscountPolicy DiscountPolicy discountPolicy) { // 생성자 주입
//        System.out.println("memberRepository = " + memberRepository);
//        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    } // 어노테이션 직접 만들기



//    @Autowired(required = false) // 필수값이 있어도 되고 없어도 된다
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//    // 수정자 주입


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원정보 조회
        int discountPrice = discountPolicy
                .discount(member, itemPrice); // 할인 정책에 회원을 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
