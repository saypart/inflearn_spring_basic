package inflern.spring;

import inflern.spring.controller.MemberController;
import inflern.spring.repository.MemberRepository;
import inflern.spring.repository.MemoryMemberRepository;
import inflern.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//자바 코드로 직접 스프링 빈 등록
//memberService 와  memberRepository 의 @Service, @Repository, @Autowired  대신 사용
public class springConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
