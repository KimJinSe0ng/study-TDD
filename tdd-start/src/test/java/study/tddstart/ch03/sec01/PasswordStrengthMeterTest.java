package study.tddstart.ch03.sec01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    //초반에 복잡한 테스트부터 시작하면 안 되는 이유
    //1.대문자 포함 규칙만 충족하는 경우
    @Test
    void meetsOnlyUpperCreteria_Then_Weak() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcDef");
        assertEquals(PasswordStrength.WEAK, result);
    }

    //2.모든 규칙을 충족하는 경우
    @Test
    void meetsAllCreteria_Then_Weak() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcDef12");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("aZcDef12"); //테스트 케이스를 추가할 때마다 if절을 계속 추가할 수 없다. -> 벌써부터 막힌다.
        assertEquals(PasswordStrength.STRONG, result2);
    }

    //정해진 값을 리턴 -> 값 비교를 이용해 정해진 값을 리턴 -> 다양한 테스트를 추가하며 구현을 일반화
    @Test
    void meetsOtherCreteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);
        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, result2);
    }
}
