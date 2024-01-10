package study.tddstart.ch08.sec01.auth;

public interface CustomerRepository {
    Customer findOne(String id);
}
