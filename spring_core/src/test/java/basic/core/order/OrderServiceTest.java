package basic.core.order;

import basic.core.AppConfig;
import basic.core.member.Grade;
import basic.core.member.Member;
import basic.core.service.MemberService;
import basic.core.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    AppConfig appConfig = new AppConfig();

    MemberService memberService;
    OrderService orderService;
//    MemberService memberService= new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    @BeforeEach
    void BeforeEach(){
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}