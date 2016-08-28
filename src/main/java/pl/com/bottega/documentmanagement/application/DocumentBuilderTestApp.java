package pl.com.bottega.documentmanagement.application;

import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.infrastructure.ColorPrintCostCalculator;
import pl.com.bottega.documentmanagement.infrastructure.ConsoleDocumentPrinter;
import pl.com.bottega.documentmanagement.infrastructure.XMLDocumentBuilder;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class DocumentBuilderTestApp {
    public static void main(String[] args) {
        DocumentNumber documentNumber = new DocumentNumber("1");
        Document document = new Document(
                documentNumber,
                "test c",
                "test t",
                new Employee(new EmployeeId(12L)),
                new ColorPrintCostCalculator()
        );

        XMLDocumentBuilder xmlDocumentBuilder = new XMLDocumentBuilder();
        document.export(xmlDocumentBuilder);
        ConsoleDocumentPrinter consoleDocumentPrinter = new ConsoleDocumentPrinter();
        document.export(consoleDocumentPrinter);

        System.out.println(xmlDocumentBuilder.xml());

    }
}
