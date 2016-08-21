package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.Document;

import java.util.Set;

/**
 * Created by arkadiuszarak on 21/08/2016.
 */
public interface PrintSystemFacade {

    void printDocuments(Document document, Set<EmployeeDetails> employeeDetailsSet);
}
