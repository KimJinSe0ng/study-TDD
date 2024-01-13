package study.tddstart.appA;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

public class TempDirTest { //@TempDir 를 이용한 임시 폴더 생성

    @TempDir
    File tempFolderFile; //테스트 메서드 실행 전에 임시 폴더를 생성하고 폴더 정보를 tempFolderFile에 넣음

    @Test
    void test1() {
        System.out.println(tempFolderFile.getAbsolutePath());
    }

    @Test
    void test2(@TempDir Path tempFolderPath) { //특정 테스트 메서드에서만 임시 폴더를 생성해서 사용하고 싶은 경우
        System.out.println(tempFolderFile.getAbsolutePath());
    }

    //테스트 실행 뒤에는 생성한 임시 폴더를 삭제한다.
}
