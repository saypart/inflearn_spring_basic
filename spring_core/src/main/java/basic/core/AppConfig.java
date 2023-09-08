package basic.core;

import basic.core.discount.DiscountPolicy;
import basic.core.discount.RateDiscountPolicy;
import basic.core.order.OrderService;
import basic.core.order.OrderServiceImpl;
import basic.core.repository.MemberRepository;
import basic.core.repository.MemoryMemberRepository;
import basic.core.service.MemberService;
import basic.core.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 빈을 싱글톤 컨테이너로 사용하기 위한  어노테이션
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        System.out.println("call AppConfig.discountPolicy");
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
