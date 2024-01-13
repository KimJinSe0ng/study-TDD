package study.tddstart.appC;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AnyMatcherTest { //인자 매칭 처리
    //ArgumentMatchers 클래스를 사용하면 정확하게 일치하는 값 대신 임의의 값에 일치하도록 설정할 수 있다.
    @Test
    void anyMatchTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(any())).willReturn("456");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("456", num);

        String num2 = genMock.generate(GameLevel.NORMAL);
        assertEquals("456", num2);
    }

    @Test
    void 스텁을_설정할_메서드의_인자가_두_개_이상인_경우() {
        //Mockito는 한 인자라도 ArgumentMatchers를 사용해서 설정한 경우 모든 인자를 ArgumentMatchers를 이용해서 설정하도록 하고 있다.
        List<String> mockList = mock(List.class);
        given(mockList.set(anyInt(), "123")).willReturn("456");
        String old = mockList.set(5, "123");
    }

    @Test
    void mixAnyAndEq() {
        //임의의 값과 일치하는 인자와 정확하게 일치하는 인자를 함께 사용하고 싶다면 ArgumentMatchers.eq()를 사용해야 한다.
        List<String> mockList = mock(List.class);

        given(mockList.set(anyInt(), eq("123"))).willReturn("456");

        String old = mockList.set(5, "123");
        assertEquals("456", old);
    }
}
