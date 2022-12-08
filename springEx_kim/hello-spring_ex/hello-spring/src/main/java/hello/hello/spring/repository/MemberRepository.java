package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // 아이디로 회원찾기
    Optional<Member> findByName(String name);
    // findBy~ 값이 없으면 null로 반환하는 방법
    List<Member> findAll();
}
