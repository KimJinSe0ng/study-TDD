package study.tddstart.appC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

    @Test
    void mockTest() {
        GameNumGen genMock = mock(GameNumGen.class); //Mockito.mock()는 특정 타입( 클래스, 인터페이스, 추상 클래스)에 대해 모의 객체를 생성할 수 있다.
        //모의 객체 생성 후에 BDDMockito 클래스를 이용해 모의 객체에 스텁을 구성할 수 있다. BDDMockito.given()를 사용하면 모의 객체의 메서드가 특정 값을 리턴하도록 설정할 수 있다.
        given(genMock.generate(GameLevel.EASY)).willReturn("123"); //genMock.generate(GameLevel.EASY) 메서드가 불리면 "123"을 리턴해라.

        String num = genMock.generate(GameLevel.EASY); //given()에서 지정한 인자와 일치하므로 generate(GameLevel.EASY)는 "123"을 리턴한다.
        assertEquals("123", num);
    }
}
