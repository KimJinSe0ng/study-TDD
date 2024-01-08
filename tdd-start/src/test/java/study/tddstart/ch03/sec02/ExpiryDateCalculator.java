package study.tddstart.ch03.sec02;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths); //후보 만료일 구함
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) { //첫 납부일의 일자와 후보 만료일의 일자가 다르면
                final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
                if (dayLenOfCandiMon < payData.getFirstBillingDate().getDayOfMonth()) {
                    return candidateExp.withDayOfMonth(dayLenOfCandiMon); //이 조건이 참이면 후보 만료일을 그달의 마지막 날로 조정
                }
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth()); //첫 납부일의 일자를 후보 만료일의 일자로 사용 + 4월 31일이 없는데 31일로 설정해서 예외 발생
            }
        }

        return payData.getBillingDate().plusMonths(addedMonths);
    }
}
