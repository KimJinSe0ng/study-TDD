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

    //첫 번째 테스트: 모든 규칙을 충족하는 경우
    @Test
    void meetsAllCriteria_Then_Strong() { //암호가 모든 조건을 충족하면 암호 강도는 강함이어야 함
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("abc1!Add");
        assertEquals(PasswordStrength.STRONG, result2);
    }
}
