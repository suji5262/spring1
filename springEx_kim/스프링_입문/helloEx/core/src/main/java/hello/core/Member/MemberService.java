package hello.core.Member;

public interface MemberService { // 인터페이스
    // 회원 가입, 회원 조회 ->  두가지 기능이 필요함

    void join(Member member);
    Member findMember(Long memberId);

}
