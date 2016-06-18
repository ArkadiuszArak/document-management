package pl.com.bottega.documentmanagement.api;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.domain.EmployeeRepository;

/**
 * Created by maciuch on 12.06.16.
 */
public class UserManager {

    private EmployeeRepository employeeRepository;

    public UserManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public SigneupResultDto signup(String login, String password, EmployeeId employeeId){
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null)
            return setupNewAccount(login, password, employeeId);
        else if (employee.isRegistered())
            return faild("employee regisered");
        else {
            employee.setupAccount(login, password);
            employeeRepository.save(employee);
            return success();
        }
    }

    private SigneupResultDto faild(String reason) {
        return new SigneupResultDto(reason);
    }

    private SigneupResultDto success(){
        return new SigneupResultDto();
    }

    private SigneupResultDto setupNewAccount(String login, String password, EmployeeId employeeId) {
        if (employeeRepository.isLoginOccupied(login))
            return faild("login is occupied");
        else {
            Employee employee = new Employee(login, hashedPassword(password), employeeId);
            employeeRepository.save(employee);
            return success();
        }
    }

    private String hashedPassword(String password) {
        return Hashing.sha1().hashString(password, Charsets.UTF_8).toString();
    }

    public void login(String login, String password){

    }

    public Employee currentEmployee() {

        return null;
    }

}
