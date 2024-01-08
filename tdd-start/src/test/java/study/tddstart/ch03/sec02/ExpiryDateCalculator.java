package study.tddstart.ch03.sec02;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(1); //후보 만료일 구함
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) { //첫 납부일의 일자와 후보 만료일의 일자가 다르면
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth()); //첫 납부일의 일자를 후보 만료일의 일자로 사용
            }
//            if (payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))) {
//                return LocalDate.of(2019, 3, 31);
//            }
        }

        return payData.getBillingDate().plusMonths(1);
    }
}
