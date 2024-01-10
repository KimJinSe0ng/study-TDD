package study.tddstart.ch08.sec01;

import study.tddstart.ch08.sec01.subs.*;

import java.time.LocalDate;

import static study.tddstart.ch08.sec01.subs.Grade.GOLD;

public class UserPointCalculator {
    private SubscriptionDao subscriptionDao;
    private ProductDao productDao;

    public UserPointCalculator(SubscriptionDao subscriptionDao,
                               ProductDao productDao) {
        this.subscriptionDao = subscriptionDao;
        this.productDao = productDao;
    }

    public int calculatePoint(User u) {
        Subscription s = subscriptionDao.selectByUser(u.getId());
        if (s == null) throw new NoSubscriptionException();
        Product p = productDao.selectById(s.getProductId());
        LocalDate now = LocalDate.now(); //실행 시점에 따라 달라지는 결과
        int point = 0;
        if (s.isFinished(now)) { //실행 시점에 따라 달라지는 결과
            point += p.getDefaultPoint(); //역할이 섞여있는 코드
        } else {
            point += p.getDefaultPoint() + 10; //역할이 섞여있는 코드
        }
        if (s.getGrade() == GOLD) {
            point += 100;
        }
        return point;
    }
}
