package study.tddstart.ch05.sec04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LifecycleTest {

    public LifecycleTest() {
        System.out.println("new Lifecycle Test");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    void a() {
        System.out.println("A");
    }

    @Test
    void b() {
        System.out.println("B");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}
