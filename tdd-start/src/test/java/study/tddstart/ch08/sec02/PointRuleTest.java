package study.tddstart.ch08.sec02;

import org.junit.jupiter.api.Test;
import study.tddstart.ch08.sec01.subs.Grade;
import study.tddstart.ch08.sec01.subs.Product;
import study.tddstart.ch08.sec01.subs.Subscription;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointRuleTest {
    @Test
    void 만료전_GOLD등급은_130포인트() throws IOException {
        PointRule rule = new PointRule();
        Subscription s = new Subscription(
                "user",
                LocalDate.of(2019, 5, 5),
                Grade.GOLD);
        Product p = new Product("pid");
        p.setDefaultPoint(20);

        int point = rule.calculate(s, p, LocalDate.of(2019, 5, 1));

        assertEquals(130, point);
    }
}
