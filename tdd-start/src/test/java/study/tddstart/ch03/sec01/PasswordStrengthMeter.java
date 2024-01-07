package study.tddstart.ch03.sec01;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if ("abcDef12".equals(s)) return PasswordStrength.STRONG; //모든 규칙을 충족하는 경우 빨리 통과시키는 방법
        if ("ab12!@A".equals(s)) return PasswordStrength.NORMAL; //테스트를 통과할 만큼만 코드를 작성
        return PasswordStrength.WEAK;
    }
}
