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

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
