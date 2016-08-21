package pl.com.bottega.documentmanagement.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.api.EmployeeDetails;
import pl.com.bottega.documentmanagement.api.MailingFaced;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.Employee;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by arkadiuszarak on 21/08/2016.
 */
@Component
public class MailingFacadeImpl implements MailingFaced {
    @Override
    public void sendDocumentPublisedEmails(Document document, Set<EmployeeDetails> employeeDetailsSet) {
        employeeDetailsSet.stream().forEach((e) -> logMailing(document,e));
    }

    private void logMailing(Document document, EmployeeDetails employeeDetails){
        String msg = String.format("Mailing info to %s about published documents %s", employeeDetails.getEmail(), document.content());
        Logger.getLogger(String.valueOf(MailingFacadeImpl.class)).info(msg);
    }
}
