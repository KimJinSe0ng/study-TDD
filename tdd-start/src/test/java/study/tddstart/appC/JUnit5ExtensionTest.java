package study.tddstart.appC;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class JUnit5ExtensionTest { //JUnit 5 확장 설정 : mockito-junit-jupiter 의존성을 추가해야 사용 가능
    //이 확장 기능을 사용하면 @Mock이 붙은 필드에 대해 자동으로 모의 객체를 생성해 준다.

    @Mock
    private GameNumGen genMock;

    @Test
    void mockStubTest() {
        given(genMock.generate(GameLevel.EASY)).willReturn("123");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123", num);
    }

    @Test
    void mockThrowTest() {
        given(genMock.generate(null)).willThrow(new IllegalArgumentException());

        assertThrows(
                IllegalArgumentException.class,
                () -> genMock.generate(null));
    }
}
