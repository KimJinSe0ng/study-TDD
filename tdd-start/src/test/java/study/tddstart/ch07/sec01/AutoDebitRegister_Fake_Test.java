package study.tddstart.ch07.sec01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Fake_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator cardNumberValidator;
    private MemoryAutoDebitInfoRepository repository; //대역 객체

    @BeforeEach
    void setUp() {
        cardNumberValidator = new StubCardNumberValidator();
        repository = new MemoryAutoDebitInfoRepository(); //대역 객체 생성
        register = new AutoDebitRegister(cardNumberValidator, repository); //대역 전달
    }

    @Test
    void alreadyRegistered_InfoUpdated() {
        repository.save( //사용 + 이미 자동이체 정보가 등록되어 있을 때 기존 정보가 올바르게 바뀌는지 검사하는 메서드
                new AutoDebitInfo("user1", "111222333444", LocalDateTime.now())); //이미 자동이체 정보가 등록되어 있는 상황을 만들기 위해 대역을 사용한다. ID가 "user1"에 대한 자동이체 정보 저장

        AutoDebitReq req = new AutoDebitReq("user1", "123456789012"); //"user1" ID에 대해 다른 카드번호를 사용해 자동이체 등록 기능을 실행한다.
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("123456789012", saved.getCardNumber()); //자동이체 등록 기능 실행 후 대역에 보관된 자동이체 정보를 구해서 값이 올바르게 변경되었는지 확인한다.
    }

    @Test
    void notYetRegistered_newInfoRegistered() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1"); //대역 사용
        assertEquals("1234123412341234", saved.getCardNumber());
    }
}
