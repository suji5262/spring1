package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em; //jpa 는 엔티티 매니저라는 것으로 동작함
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
        // jpa 가 insert 쿼리 다 만들어서 집어넣음, ex) id -> member 로
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);// 조회타입, 식별자 pk 만 넣으면 됨
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

}
