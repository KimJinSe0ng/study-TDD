package study.tddstart.ch07.sec04;

public class StubWeakPasswordChecker implements WeakPasswordChecker {

    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }
}
