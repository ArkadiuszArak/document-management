package pl.com.bottega.documentmanagement.api;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.domain.EmployeeRepository;

/**
 * Created by maciuch on 12.06.16.
 */
@Service
public class UserManager {

    private Employee currentEmployee;
    private EmployeeRepository employeeRepository;
    @Autowired
    public UserManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
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


    public SigneupResultDto login(String login, String password){
        this.currentEmployee  = employeeRepository.findByLoginAndPassword(login, hashedPassword(password));
        if (this.currentEmployee() == null)
            return faild("Login or pass incorrect");
        else
            return success();
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "currentEmployee=" + currentEmployee +
                ", employeeRepository=" + employeeRepository +
                '}';
    }

    public Employee currentEmployee() {

        return this.currentEmployee;
    }

}
