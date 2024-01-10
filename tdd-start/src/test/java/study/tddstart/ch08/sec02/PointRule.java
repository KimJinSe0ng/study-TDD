package study.tddstart.ch08.sec02;

import study.tddstart.ch08.sec01.subs.Product;
import study.tddstart.ch08.sec01.subs.Subscription;

import java.time.LocalDate;

import static study.tddstart.ch08.sec01.subs.Grade.GOLD;

public class PointRule {

    public int calculate(Subscription s, Product p, LocalDate now) {
        int point = 0;
        if (s.isFinished(now)) {
            point += p.getDefaultPoint();
        } else {
            point += p.getDefaultPoint() + 10;
        }
        if (s.getGrade() == GOLD) {
            point += 100;
        }
        return point;
    }
}
