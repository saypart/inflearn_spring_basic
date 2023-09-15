package basic.core.web;

import basic.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    /**  생성을 지연하기 위해  ObjectProvider 를 사용 */
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    /**실제 고객이 요청이 와야 생성할수 있는 로직이라 초기 구동시 에러 발생  */ // proxyMode 로 해결 가능
        private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestUrl = request.getRequestURI().toString();
//        MyLogger myLogger = myLoggerProvider.getObject(); //프로바이더 사용을 위한 추가
        System.out.println("myLogger = "+ myLogger.getClass());
        myLogger.setRequestURL(requestUrl);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
