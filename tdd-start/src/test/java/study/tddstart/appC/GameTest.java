package study.tddstart.appC;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;

public class GameTest {
    /**
     * BDDMockito.then()은 메서드 호출 여부를 검증할 모의 객체를 전달 받는다.
     * should() 메서드는 모의 객체의 메서드가 불려야 한다는 것을 설정하고 should() 메서드 다음에 실제로 불려야 할 메서드를 지정한다.
     */

    @Test
    void init() {
        GameNumGen genMock = mock(GameNumGen.class);
        Game game = new Game(genMock);;
        game.init(GameLevel.EASY);

        then(genMock).should(only()).generate(GameLevel.EASY); //정확한 값이 불렸는지 확인
        then(genMock).should().generate(any()); //메서드가 불렸는지 확인
        then(genMock).should(only()).generate(any()); //정확하게 한 번만 메서드가 불렸는지 확인
    }
}
