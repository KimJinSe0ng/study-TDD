package study.tddstart.ch07.sec04;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) { //암호가 약한지 검사
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
