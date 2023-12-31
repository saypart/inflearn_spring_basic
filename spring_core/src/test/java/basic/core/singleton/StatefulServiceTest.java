package basic.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA :  A사용자 10000원 주문
        statefulService1.order("userA",10000);

        //Threadb :  b사용자 20000원 주문
        statefulService1.order("userB",20000);

        //ThreadA :  A사용자 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = "+price);

        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }
    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}