package hello.hello.spring.controller;

import hello.hello.spring.domain.Member;
import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        System.out.println("memberService = " + memberService.getClass());
    } // 생성자 호출
    // Autowired > 스프링에 있는 memberService 를 스프링이 연결시킴 > 의존관계 주입
    // 생성자를 통해 -> memberService -> MemberController 에 주입됨

    @GetMapping("members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

//        System.out.println("member = " + member.getName()); // 브라우저에서 들어온 값을 콘솔에 출력

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // -> List 에 있는 모든 멤버들을 모델에 담아서 뷰로 넘김
        return "members/memberList";
    }

}
