package study.tddstart.ch08.sec02;

import net.bytebuddy.asm.Advice;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyBatchLoader {
    /**
     * 시간이나 임의의 값을 사용하면 테스트 시점에 따라 결과가 달라질 수 있다.
     * 이 경우 테스트 대상이 사용하는 시간이나 임의 값을 제공하는 기능을 별도로 분리해서 테스트 가능성을 높일 수 있다.
     */
    private String basePath = ".";

    public int load() {
        LocalDate date = LocalDate.now(); //테스트를 실행하는 일자에 따라 값이 달라지므로 결과도 달라진다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Path batchPath = Paths.get(basePath, date.format(formatter), "batch.txt");

        // ...batchPath에서 데이터를 읽어와 저장하는 코드

        return 0;
    }
}
