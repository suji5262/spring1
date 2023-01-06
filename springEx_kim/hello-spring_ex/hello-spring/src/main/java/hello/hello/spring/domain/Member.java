package hello.hello.spring.domain;

import javax.persistence.*;

// @Entity ->jpa 가 관리하는 엔티티
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해주는 것 -> IDENTITY

    private Long id; // 시스템이 저장하는 아이디

//    @Column(name = "username") // db 에 컬럼명이 username 이라면
    private String name;

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
