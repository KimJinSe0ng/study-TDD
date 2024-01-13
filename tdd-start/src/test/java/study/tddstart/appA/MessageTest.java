package study.tddstart.appA;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest { //테스트 메시지
    @Test
    void message() {
        List<Integer> ret = getResults();
        List<Integer> expected = Arrays.asList(1, 2, 3);
        for (int i = 0 ; i < expected.size() ; i++) {
            assertEquals(expected.get(i), ret.get(i), "ret[" + i + "]"); //세 번째 인자에 설명 문자열 추가 가능
        }
    }

    private List<Integer> getResults() {
        return Arrays.asList(1, 6, 3);
    }

}
