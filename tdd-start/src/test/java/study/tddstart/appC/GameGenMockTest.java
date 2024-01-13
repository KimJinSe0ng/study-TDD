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
    }
}
