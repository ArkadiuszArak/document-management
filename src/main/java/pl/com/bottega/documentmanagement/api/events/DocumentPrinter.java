package pl.com.bottega.documentmanagement.api.events;

import com.google.common.collect.Sets;
import pl.com.bottega.documentmanagement.api.EmployeeDetails;
import pl.com.bottega.documentmanagement.api.HRSystemFacade;
import pl.com.bottega.documentmanagement.api.PrintSystemFacade;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.Reader;
import pl.com.bottega.documentmanagement.domain.events.DocumentListener;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by arkadiuszarak on 27/08/2016.
 */
public class DocumentPrinter implements DocumentListener {

    private PrintSystemFacade printSystemFacade;
    private HRSystemFacade hrSystemFacade;

    public DocumentPrinter(HRSystemFacade hrSystemFacade, PrintSystemFacade printSystemFacade) {
        this.hrSystemFacade = hrSystemFacade;
        this.printSystemFacade = printSystemFacade;
    }

    @Override
    public void published(Document document) {
        Set<Reader> readers = document.readers();
        Set<Employee> employeesIds = new HashSet<>();
        for (Reader reader : readers){
            employeesIds.add(reader.employeeID());
        }
        Set<EmployeeDetails> employeeDetailsSet = hrSystemFacade.getEmployeeDetails(Sets.newHashSet(employeesIds));
        printDocument(document, employeeDetailsSet);
    }

    private void printDocument(Document document, Set<EmployeeDetails> employeeDetailsSet) {
        Set<EmployeeDetails> employeesWithoutEmail = employeeDetailsSet.stream().
                filter(employeeDetails -> !employeeDetails.hasEmail()).collect(Collectors.toSet());
        printSystemFacade.printDocument(document, employeesWithoutEmail);
    }
}
