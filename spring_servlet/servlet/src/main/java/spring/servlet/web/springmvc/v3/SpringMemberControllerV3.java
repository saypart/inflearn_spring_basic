package spring.servlet.web.springmvc.v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.servlet.domain.member.Member;
import spring.servlet.domain.member.MemberRepository;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @GetMapping("/new-form") // 아래줄 기능이 포함됨
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) // method  메서드 요청 제한 설정
    public String newForm(){
        return "new-form";
    }

    @GetMapping // 아래줄 기능이 포함됨
//    @RequestMapping(method = RequestMethod.GET)
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);

        return "members";
    }

    @PostMapping("/save") // 아래줄 기능이 포함됨
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}
