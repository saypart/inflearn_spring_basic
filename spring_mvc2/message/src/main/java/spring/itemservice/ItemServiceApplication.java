package spring.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	/** 스프링 부트 사용시엔 자동 적용 되어 있어 설정 불필요
	 @Bean
	 public MessageSource messageSource(){
	 ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	 messageSource.setBasenames("messages", "errors");
	 messageSource.setDefaultEncoding("utf-8");
	 return messageSource;
	 }
	 */
}
