package pl.com.bottega.documentmanagement.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.api.EmployeeDetails;
import pl.com.bottega.documentmanagement.api.MailingFaced;
import pl.com.bottega.documentmanagement.api.PrintSystemFacade;
import pl.com.bottega.documentmanagement.domain.Document;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by arkadiuszarak on 21/08/2016.
 */
@Component
public class PrintSytemFacedImpl implements PrintSystemFacade {
    @Override
    public void printDocuments(Document document, Set<EmployeeDetails> employeeDetailsSet) {
      //  employeeDetailsSet.forEach(this::logPrint);
    }

    private void logPrint(Document document, EmployeeDetails employeeDetails){
        String msg = String.format("Printing documents for %s", employeeDetails);
        Logger.getLogger(String.valueOf(PrintSystemFacade.class)).info(msg);
    }
}
