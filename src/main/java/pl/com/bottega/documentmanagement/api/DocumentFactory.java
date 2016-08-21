package pl.com.bottega.documentmanagement.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumberGenerator;
import pl.com.bottega.documentmanagement.domain.PrintingCostCalculator;


/**
 * Created by maciuch on 17.08.16.
 */
@Component
public class DocumentFactory {

    private DocumentNumberGenerator documentNumberGenerator;

    private UserManager userManager;

    private PrintingCostCalculator printingCostCalculator;

    public DocumentFactory(DocumentNumberGenerator documentNumberGenerator, UserManager userManager, PrintingCostCalculator printingCostCalculator) {
        this.documentNumberGenerator = documentNumberGenerator;
        this.userManager = userManager;
        this.printingCostCalculator = printingCostCalculator;
    }

    public Document create(String title, String content) {
        return new Document(documentNumberGenerator.generate(), content, title, userManager.currentEmployee(), printingCostCalculator);
    }

}
