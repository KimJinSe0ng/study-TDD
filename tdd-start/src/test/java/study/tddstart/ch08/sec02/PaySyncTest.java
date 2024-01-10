package study.tddstart.ch08.sec02;

import org.junit.jupiter.api.Test;
import study.tddstart.ch08.sec01.payinfo.PayInfo;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaySyncTest {
    private MemoryPayInfoDao memoryDao = new MemoryPayInfoDao(); //대역 생성

    @Test
    void allDataSaved() throws IOException {
        PaySync3 paySync = new PaySync3();
        paySync.setPayInfoDao(memoryDao); //대역으로 교체
        paySync.setFilePath("src/test/resources/c0111.csv");

        paySync.sync();

        List<PayInfo> savedInfos = memoryDao.getAll();
        assertEquals(2, savedInfos.size());
    }
}
