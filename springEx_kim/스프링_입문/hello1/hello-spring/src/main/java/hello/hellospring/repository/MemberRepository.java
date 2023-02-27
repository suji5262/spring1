package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // 회원이 저장소에 저장 됨

    Optional<Member> findById(Long id); // id 로 회원을 찾는 기능

    Optional<Member> findByName(String name); // name 으로 회원을 찾음

    List<Member> findAll(); // 지금까지 저장된 모든 회원 list 를 반환

    // 저장소에서 id, name, all 회원을 찾을 수 있음


}
