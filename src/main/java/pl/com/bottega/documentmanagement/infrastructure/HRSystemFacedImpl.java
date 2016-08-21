package pl.com.bottega.documentmanagement.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.api.EmployeeDetails;
import pl.com.bottega.documentmanagement.api.HRSystemFacade;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by arkadiuszarak on 21/08/2016.
 */
@Component
public class HRSystemFacedImpl implements HRSystemFacade {
    @Override
    public Set<EmployeeDetails> getEmployeeDetails(Set<EmployeeId> employees) {

        Set<EmployeeDetails> employeeDetailsSet = new HashSet<>();

        for (EmployeeId employee :employees){
            EmployeeDetails employeeDetails = new EmployeeDetails();
            employeeDetails.setFirsName("Jan");
            employeeDetails.setLastName("Nowak");
            employeeDetails.setAddress("Polnicna 12");
            employeeDetails.setEmail("jan.nwak@gmail.com");
            employeeDetailsSet.add(employeeDetails);
        }

/*        return employees.stream().map((employee -> {
            EmployeeDetails employeeDetails = new EmployeeDetails();
            employeeDetails.setFirsName("Jan");
            employeeDetails.setLastName("Nowak");
            employeeDetails.setAddress("Polnicna 12");
            employeeDetails.setEmail("jan.nwak@gmail.com");
            employeeDetailsSet.add(employeeDetails);
            return employeeDetailsSet;
        }).collect(Collectors.toSet());*/

        return employeeDetailsSet;
    }
}
