package study.tddstart.ch07.sec04;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;

    public UserRegister(WeakPasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) { //암호가 약한지 검사
            throw new WeakPasswordException();
        }
    }
}
