package study.tddstart.ch07.sec04;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;

    public UserRegister(WeakPasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

    public void register(String id, String pw, String email) {
        throw new WeakPasswordException();
    }
}
