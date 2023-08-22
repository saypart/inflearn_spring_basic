package inflern.spring.service;

import inflern.spring.domain.Member;
import inflern.spring.repository.MemberRepository;
import inflern.spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // TEST시 DB로 롤벡 해줌
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @BeforeEach
    public void BeforeEach(){
    }


    @Test
    void join() {
        //given
        Member member =new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 =new Member();
        member1.setName("spring");
        Member member2 =new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
        //then
    }



    @Test
    void findMembers() {
        //given
        //when
        //then
    }

    @Test
    void findOne() {
        //given
        //when
        //then
    }

}