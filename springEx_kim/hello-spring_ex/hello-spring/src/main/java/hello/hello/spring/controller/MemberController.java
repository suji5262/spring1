package hello.hello.spring.controller;

import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } // 생성자 호출
    // Autowired > 스프링에 있는 memberService 를 스프링이 연결시킴 > 의존관계 주입
}
