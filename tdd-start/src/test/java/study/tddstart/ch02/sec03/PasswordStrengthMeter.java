package study.tddstart.ch02.sec03;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        int metCount = 0;
        if (s.length() >= 8) metCount++;
        if (meetsContainingNumberCriteria(s)) metCount++;
        if (meetsContainingUppercaseCriteria(s)) metCount++;
//        if (!lengthEnough) return PasswordStrength.NORMAL;
//        if (!containsNum) return PasswordStrength.NORMAL;
//        if (!containsUpp) return PasswordStrength.NORMAL;
        if (metCount == 1) return PasswordStrength.WEAK;
        if (metCount == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private static boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private static boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
