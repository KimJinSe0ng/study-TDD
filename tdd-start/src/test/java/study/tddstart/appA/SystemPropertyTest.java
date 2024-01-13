package study.tddstart.appA;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemPropertyTest { //조건에 따른 테스트 - 시스템 프로퍼티 값 비교

    @Test
    @EnabledIfSystemProperty(named = "java.vm.name", matches = ".*OpenJDK.*")
    void openJdk() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vm.name", matches = ".*OpenJDK.*")
    void notOpenJdk() {
        assertEquals(2, 1 + 1);
    }
}
