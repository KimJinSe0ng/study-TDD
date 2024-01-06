package study.tddstart.ch02.sec02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    /**
     * 메서드 이름은 plus가 좋을까? sum이 좋을까?
     * 덧셈 기능을 제공하는 메서드는 파라미터가 몇 개여야 할까? 파리미터의 타입은? 반환할 값은?
     * 메서드를 정적 메서드로 구현할까 인스턴스 메서드로 구현할까?
     * 메서드를 제공할 클래스 이름은 뭐가 좋을까?
     * -> 덧셈 기능을 제공할 클래스, 메서드, 반환 타입 등에 대해 고민했다.
     */
    @Test //JUnit은 @Test 애노테이션을 붙인 메서드를 테스트 메서드로 인식 -> 테스트 메서드란? 기능을 검증하는 코드를 담고 있는 메서드
    void plus() {
        int result = Calculator.plus(1, 2);
        assertEquals(3, result); //기대값과 실제값이 동일한지 비교, 첫번째 인자: 기대한 값, 두번째 인자: 실제 값
    }
}
