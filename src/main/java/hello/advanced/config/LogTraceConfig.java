package hello.advanced.config;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // @Configuration 안에는 @Component 포함되어 있음
public class LogTraceConfig {

    @Bean // 수동으로 빈 등록
    public LogTrace logTrace() {
//        return new FieldLogTrace(); // 싱글턴으로 등록 -> 하나의 인스턴스
        return new ThreadLocalLogTrace(); // Thread Local
    }
}
