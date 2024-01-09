package study.tddstart.ch07.sec01;

public class StubCardNumberValidator extends CardNumberValidator { //CardNumberValidator를 대신할 대역 클래스
    //실제 카드번호 검증 기능을 구현하지 않는다. 단순한 구현으로 실제 구현을 대체한다.
    //StubCardNumberValidator는 setInvalidNo()로 지정한 카드번호에 대해서는 INVALID를 리턴하고 그 외 나머지는 VALID를 리턴한다.
    private String invalidNo;
    private String theftNo; //도난 카드에 대한 테스트를 진행하기 위해 추가

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    public void setTheftNo(String theftNo) {
        this.theftNo = theftNo;
    }

    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        if (theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.THEFT;
        }
        return CardValidity.VALID;
    }
}
