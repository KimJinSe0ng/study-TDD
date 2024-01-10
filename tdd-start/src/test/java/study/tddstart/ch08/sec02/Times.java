package study.tddstart.ch08.sec02;

import java.time.LocalDate;

public class Times {
    //현재 일자를 구하는 기능을 분리하고 분리한 대상을 주입할 수 있게 변경했다. -> 현재 일자를 구하는 기능을 분리
    public LocalDate today() {
        return LocalDate.now();
    }
}
