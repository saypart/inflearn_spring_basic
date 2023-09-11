package basic.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 자동으로 스프링 빈 등록 해주는 기능
@ComponentScan(
        basePackages = "basic.core", //패키지 경로로만 지정 가능
        //미지정시는 package의(config의 파일위치) 경로로 자동 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //@Component 도 자동 스캔하여 빈으로 등록 하는 것을 막기 위한 필터 추가
)
public class AutoAppConfig {

}
