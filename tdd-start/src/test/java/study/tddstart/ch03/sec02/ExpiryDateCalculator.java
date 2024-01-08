package study.tddstart.ch03.sec02;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
}
