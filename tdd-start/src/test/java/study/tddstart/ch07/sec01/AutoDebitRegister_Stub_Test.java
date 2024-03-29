package study.tddstart.ch07.sec01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static study.tddstart.ch07.sec01.CardValidity.INVALID;

public class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository); //AutoDebitRegister 객체를 생성할 때 생성자로 StubCardNumberValidator 객체를 전달함
        //즉, AutoDebitRegister는 실제 객체 대신에 StubCardNumberValidator을 사용해서 카드번호가 유효한지 검사한다.
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req); //유효하지 않은 카드에 대해 register()를 실행

        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard() { //도난 카드번호에 대한 자동이체 기능 테스트
        stubValidator.setTheftNo("1234567890123456");

        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);

        assertEquals(CardValidity.THEFT, result.getValidity());
    }
}
