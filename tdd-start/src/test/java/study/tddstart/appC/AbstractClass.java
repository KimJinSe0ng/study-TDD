package study.tddstart.appC;

public abstract class AbstractClass {
    public abstract int nextNum();

    public void printNext() {
        System.out.println(nextNum());
    }
}
