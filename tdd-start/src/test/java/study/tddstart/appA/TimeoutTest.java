package study.tddstart.appA;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest { //@Timeout 를 이용한 테스트 실행 시간 검증
    @Test
    @Timeout(1) //다음 메서드가 1초안에 실행되는지 테스트
    void sleep2seconds() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void sleep40Mills() throws InterruptedException {
        Thread.sleep(40);
    }
}
