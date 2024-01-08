package study.tddstart.ch05.sec06;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("@DisplayName 테스트")
public class DisplayNameTest {

    @DisplayName("AAA")
    @Test
    void a() {
        System.out.println("a");
    }

    @Disabled
    @Test
    void b() {
        System.out.println("b");
    }
}
