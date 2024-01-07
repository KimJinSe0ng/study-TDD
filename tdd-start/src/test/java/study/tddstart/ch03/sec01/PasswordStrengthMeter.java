package study.tddstart.ch03.sec01;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if ("abcDef12".equals(s)) return PasswordStrength.STRONG; //모든 규칙을 충족하는 경우 빨리 통과시키는 방법
        if (s.length() < 8) return PasswordStrength.NORMAL; //일반화
        return PasswordStrength.WEAK;
    }
}
