package hello.core.Member;

public interface MemberRepository { // 저장, 조회

    void save(Member member); // 멤버 저장

    Member findById(Long memberId); // 회원을 찾는 기능
}
