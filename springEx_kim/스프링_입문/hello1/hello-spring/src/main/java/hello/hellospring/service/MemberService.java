package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 외부에서 넣어주도록
    // 생성자를 호출


    /**
     * 회원가입 - join
     */
    public Long join(Member member) { // 중복회원 확인 후 가입

//        long start = System.currentTimeMillis();// 시간측정

//        try {
//            validateDuplicateMember(member);
//            memberRepository.save(member);
//            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join = " + timeMs + "ms");
//
//        }

//         같은 이름이 있는 중복회원은 x
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId(); // id 값을 반환

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();

//        long start = System.currentTimeMillis();
//        try {
//            return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("findMembers = " + timeMs + "ms");
//        }

    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
