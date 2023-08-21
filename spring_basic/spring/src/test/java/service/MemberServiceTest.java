package service;

import inflern.spring.domain.Member;
import inflern.spring.repository.MemoryMemberRepository;
import inflern.spring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    //테스트는 한글로 해도 무관

    MemberService memberService;
    MemoryMemberRepository memberRepository;


//    MemberService memberService = new MemberService();
//    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    Member member = new Member();
    Member member1 = new Member();
    Member member2 = new Member();
    @BeforeEach
    public void BeforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        member.setName("hello");
        member1.setName("spring");
        member2.setName("spring");
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }



    @Test
    void join() {
        //given
        /** BeforeEach 로 처리 */
        //when
        Long seveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(seveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given

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