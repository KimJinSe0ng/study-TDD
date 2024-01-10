package study.tddstart.ch08.sec02;

import study.tddstart.ch08.sec01.auth.AuthUtil;

public class AuthService { //외부 라이브러리를 감싼 클래스
    private String authKey = "somekey";

    public int authenticate(String id, String pw) {
        boolean authorized = AuthUtil.authorize(authKey);
        if (authorized) {
            return AuthUtil.authenticate(id, pw);
        } else {
            return -1;
        }
    }
}
