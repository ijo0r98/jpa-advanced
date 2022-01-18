package hello.advanced.trace.ThreadLocal;

import hello.advanced.trace.ThreadLocal.code.FieldService;
import hello.advanced.trace.ThreadLocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = new Runnable() { 
            @Override
            public void run() {
                threadLocalService.logic("userA");
            }
        };
        Runnable userB = () -> { 
            threadLocalService.logic("userB");
        };
        
        Thread threadA = new Thread(userA);
        threadA.setName("thread-B");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");
        
        threadA.start(); // threadA 로직 실행
//        sleep(2000); // A가 완전히 끝난 후 -> 동시성 문제가 발생하지 않는 코드
        sleep(100); // A가 완전히 끝나기 전 -> 동시성 문제 발생
        threadB.start(); // threadB
        sleep(3000); // 메인 스레드 종료 대기, sleep하지 않을 경우 메인 스레드 바로 종료
        log.info("main exit");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
