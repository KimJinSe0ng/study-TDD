package study.tddstart.appC;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

public class VoidMethodStubTest { //BDDMockito.given()을 이용한 스텁 설정
    @Test
    void voidMethodWillThrowTest() {
        List<String> mockList = mock(List.class);
        willThrow(UnsupportedOperationException.class)
                .given(mockList) //given()는 모의 객체를 전달 받는다. 모의 객체 메서드 실행이 아니라 모의 객체임에 유의하자.
                .clear();

        assertThrows(
                UnsupportedOperationException.class,
                () -> mockList.clear()
        );
    }
}
