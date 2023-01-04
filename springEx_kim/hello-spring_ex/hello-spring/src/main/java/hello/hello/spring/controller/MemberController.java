package hello.hello.spring.controller;

import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private  MemberService memberService;



    //    @Autowired private MemberService memberService;
// 생성자를 빼고 필드에  -> 필드주입(별로 안 좋음 -> 바꿀 수 없음)

//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    } // setter 주입 -> MemberController 를 호출했을 때 public 으로 열려있어야 함(노출됨)

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } // 생성자 호출
    // Autowired > 스프링에 있는 memberService 를 스프링이 연결시킴 > 의존관계 주입
    // 생성자를 통해 -> memberService -> MemberController 에 주입됨
}
