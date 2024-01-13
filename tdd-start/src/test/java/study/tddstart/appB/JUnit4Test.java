
package study.tddstart.appB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JUnit4Test { //JUnit 4 테스트
    @Before
    public void setUp() {

    }

    @Test
    public void plus() {
        assertEquals(2, 1 + 1);
    }

    @Test(expected = ArithmeticException.class) //JUnit 4에서 익셉션 발생 여부 테스트는 expected 속성을 사용함
    public void throwEx() {
        divide(1, 0);
    }

    @Test
    public void throwEx2() { //발생한 익셉션 객체를 사용해 추가 검증을 해야 할 때는 expected 속성을 사용하지 못하고 try-catch를 사용해 직접 검증 처리 해야 함
        ArithmeticException thrown = null;
        try {
            divide(1, 0);
        } catch(ArithmeticException ex) {
            thrown = ex;
        }
        assertNotNull(thrown);
        assertTrue(thrown.getMessage().contains("zero"));
    }

    private int divide(int a1, int a2) {
        return a1 / a2;
    }

    @After
    public void tearDown() {

    }
}
