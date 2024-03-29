package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

//    private MemberService memberService;
//
//    @Autowired
//    public void setMemberService(MemberService memberService) { // setter 주입
//        this.memberService = memberService;
//    }


//    @Autowired // 필드 주입
//    private MemberService memberService;


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { // 생성자 주입
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
    }


    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName()); // 확인할 수 있음

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

}
