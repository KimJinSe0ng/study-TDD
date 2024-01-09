package study.tddstart.ch07.sec01;

public interface AutoDebitInfoRepository { //DB 연동 코드도 대역을 사용하기에 적합하다.
    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
