package basic.core;

import basic.core.member.Grade;
import basic.core.member.Member;
import basic.core.order.Order;
import basic.core.order.OrderService;
import basic.core.order.OrderServiceImpl;
import basic.core.service.MemberService;
import basic.core.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.OrderComparator;

public class OrderApp {

    public static void main(String[] args) {
/**스프링 미사용시*/
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


        //        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null,null);
/**스프링 사용*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itmeA",20000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = "+ order.calculatePrice());
    }
}
