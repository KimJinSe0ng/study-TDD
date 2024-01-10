package study.tddstart.ch08.sec01;

import study.tddstart.ch08.sec01.auth.AuthUtil;
import study.tddstart.ch08.sec01.auth.Customer;
import study.tddstart.ch08.sec01.auth.CustomerRepository;
import study.tddstart.ch08.sec01.auth.LoginResult;

public class LoginService {
    private String authKey = "somekey";
    private CustomerRepository customerRepo;

    public LoginService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public LoginResult login(String id, String pw) {
        int resp = 0;
        boolean authorized = AuthUtil.authorize(authKey);
        if (authorized) {
            resp = AuthUtil.authenticate(id, pw);
        } else {
            resp = -1;
        }
        if (resp == -1) return LoginResult.badAuthKey();

        if (resp == 1) {
            Customer c = customerRepo.findOne(id);
            return LoginResult.authenticated(c);
        } else {
            return LoginResult.fail(resp);
        }
    }

}
