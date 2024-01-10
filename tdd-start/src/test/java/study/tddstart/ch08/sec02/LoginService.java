package study.tddstart.ch08.sec02;

import study.tddstart.ch08.sec01.auth.AuthUtil;
import study.tddstart.ch08.sec01.auth.Customer;
import study.tddstart.ch08.sec01.auth.CustomerRepository;
import study.tddstart.ch08.sec01.auth.LoginResult;

public class LoginService {
    private AuthService authService = new AuthService(); //분리한 타입 사용
    private CustomerRepository customerRepo;

    public LoginService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void setAuthService(AuthService authService) { //분리한 타입 사용
        this.authService = authService;
    }

    public LoginResult login(String id, String pw) {
        int resp = authService.authenticate(id, pw); //분리한 타입 사용
        if (resp == -1) return LoginResult.badAuthKey();

        if (resp == 1) {
            Customer c = customerRepo.findOne(id);
            return LoginResult.authenticated(c);
        } else {
            return LoginResult.fail(resp);
        }
    }

}
