package basic.core.web;

import basic.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    /**  생성을 지연하기 위해  ObjectProvider 를 사용 */
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    /**실제 고객이 요청이 와야 생성할수 있는 로직 이라 초기 구동시 에러 발생  */ // proxyMode 로 해결 가능
        private final MyLogger myLogger;

    public void logic(String id){
//        MyLogger myLogger = myLoggerProvider.getObject(); //프로바이더 사용을 위한 추가
        myLogger.log("service id = " +id);
    }
}
