package basic.core.member;

import basic.core.AppConfig;
import basic.core.service.MemberService;
import basic.core.service.MemberServiceImpl;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
//    MemberService memberService= new MemberServiceImpl();
    @Test
     void join(){
        //give
        Member member = new Member(1L,"membarA",Grade.VIP);

        //when
        memberService.join(member);
        Member findmember = memberService.findMember(1L);


        //then
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}
