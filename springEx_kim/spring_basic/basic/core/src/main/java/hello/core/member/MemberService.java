package hello.core.member;

public interface MemberService { // 회원 가입, 조회

    void join(Member member); // 가입

    Member findMember(Long memberId); // 조회

}
