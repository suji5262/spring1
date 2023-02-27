package hello.core.Member;

public class MemberServiceImpl implements MemberService { // 구현체

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // null pointException 이 터질수도 있으므로 구현객체 넣어야함
    // MemberRepository, MemoryMemberRepository -> 두개를 다 의존하고 있음(추상화, 구체화) -> DIP위반

    @Override
    public void join(Member member) {
        memberRepository.save(member); // MemoryMemberRepository 에 있는 save 가 호출

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
