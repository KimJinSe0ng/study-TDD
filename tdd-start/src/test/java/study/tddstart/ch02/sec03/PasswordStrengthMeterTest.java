package study.tddstart.ch02.sec03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD 예: 암호 검사기
 * 암호 검사기는 문자열을 검사해 규칙을 준수하는지에 따라 암호를 '약함, 보통, 강함'으로 구분한다.
 * 검사할 규칙은 다음과 같다.
 * 1. 길이가 8글자 이상
 * 2. 0부터 9사이의 숫자를 포함
 * 3. 대문자 포함
 * 세 규칙을 모두 충족하면 '강함', 2개의 규칙을 충족하면 '보통', 1개 이하의 규칙을 충족하면 '약함'
 */
public class PasswordStrengthMeterTest { //1.테스트할 기능의 이름 정하기

    private PasswordStrengthMeter meter = new PasswordStrengthMeter(); //중복 제거

    private void assertStrength(String password, PasswordStrength expStr) { //중복 제거
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    //첫 번째 테스트: 모든 규칙을 충족하는 경우
    @Test
    void meetsAllCriteria_Then_Strong() { //암호가 모든 조건을 충족하면 암호 강도는 강함이어야 함
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    //두 번째 테스트: 길이가 8글자 미만이고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("AB12!c", PasswordStrength.NORMAL);
    }

    //세 번째 테스트: 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    //네 번째 테스트: 값이 없는 경우 - null
    //null을 입력할 경우 어떻게 반응해야 할까?
    //1. IllegalArgumentException을 발생한다. 2. 유효하지 않은 암호를 의미하는 PasswordStrength.INVALID를 리턴한다.
    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    //네 번째 테스트: 값이 없는 경우 - 빈 문자열
    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    //다섯 번째 테스트: 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
    @Test
    void meetsOthereCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    //여섯 번째 테스트: 길이가 8글자 이상인 조건만 충족하는 경우
    //남은 것은 한 가지 조건만 충족하거나 모든 조건을 충족하지 않는 경우이다.
    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    //일곱 번째 테스트: 숫자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    //여덟 번째 테스트: 대문자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    //아홉 번째 테스트: 아무 조건도 충족하지 않은 경우
    //기대값: WEAK, 실제값: STRONG
    //테스트를 통과시키기 위한 방법
    //1.충족 개수가 1개 이하인 경우 WEAK를 리턴하도록 수정
    //2.충족 개수가 0개인 경우 WEAK를 리턴하는 코드 수정
    //3.충족 개수가 3개인 경우 STRONG을 리턴하는 코드를 추가하고 마지막에 WEAK를 리턴하도록 코드 수정
    @Test
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
