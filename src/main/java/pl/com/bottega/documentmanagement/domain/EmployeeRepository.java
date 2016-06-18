package pl.com.bottega.documentmanagement.domain;

/**
 * Created by arkadiuszarak on 18/06/2016.
 */
public interface EmployeeRepository {
    void save(Employee employee);
    Employee findByEmployeeId(EmployeeId employeeId);

    boolean isLoginOccupied(String login);
}
