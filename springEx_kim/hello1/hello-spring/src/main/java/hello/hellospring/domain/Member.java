package hello.hellospring.domain;

import org.hibernate.mapping.Column;

import javax.persistence.*;

@Entity
public class Member { // 요구사항

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 아이디 식별자
    // 임의의 값, 데이터를 구분하기 위해 시스템이 저장하는 값

    private String name; // 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
