package hello.advanced.trace.ThreadLocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

//    private String nameStore;
    private ThreadLocal<String> nameStore = new ThreadLocal<>(); // <저장할 타입>

    public String logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, nameStore.get()); // 객체이기 때문에 get, set, remove 사용해야 함
        nameStore.set(name);
        sleep(1000); // 저장하는데 1초 걸린다고 가정
        log.info("조회 nameStore={}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
