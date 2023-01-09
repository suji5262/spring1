package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import hello.hello.spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional // 데이터를 저장, 변경할 때 사용

public class MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 외부에서 넣어주도록 바꿔줘
    // 생성자를 통해 들어옮 -> 생성자 주입

    public Long join(Member member) {

        /*
        * 시간 측정 aop
        * */
        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member); // 중복회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }

        /*
        회원가입
        * */
//        Optional<Member> result = memberRepository.findByName(member.getName()); // Optional 를 바로 반환하는게 좋지 않음
        // 같은 이름이 있는 중복 회원 x
//        validateDuplicateMember(member); // 중복회원 검증
//        memberRepository.save(member);
//        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    public List<Member> findMembers() {
        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    }



    /*
    * 전체회원조회
    * */

//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
