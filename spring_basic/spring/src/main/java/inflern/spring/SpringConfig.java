package inflern.spring;

import inflern.spring.aop.TimeTraceAop;
import inflern.spring.repository.JpaMemberRepository;
import inflern.spring.repository.MemberRepository;
import inflern.spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
/**자바 코드로 직접 스프링 빈 등록
memberService 와  memberRepository 의 @Service, @Repository, @Autowired  대신 사용*/
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository){
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }


//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }

/**Spring data jpa 사용시 */
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/** Spring Data Jpa 사용시 비활성화 */
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource); // 순수 JDBC
//        return new JdbcTemplateMemberRepository(dataSource); // JDBC Template
//        return new JpaMemberRepository(em); // JPA
//    }


/** @Component 미사용시 빈으로 등록하여 사용 가능 */
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

}
