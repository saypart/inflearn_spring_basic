package basic.core;

import basic.core.member.Grade;
import basic.core.member.Member;
import basic.core.service.MemberService;
import basic.core.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
/**스프링 미사용시*/
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();
/**스프링 사용시*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "merberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
