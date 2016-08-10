package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.DocumentNumberGenerator;
import pl.com.bottega.documentmanagement.domain.Employee;

/**
 * Created by arkadiuszarak on 10/08/2016.
 */
public class DocumentFactory {
    private DocumentNumberGenerator documentNumberGenerator;
    private UserManager userManager;

    public DocumentFactory(DocumentNumberGenerator documentNumberGenerator, UserManager userManager) {
        this.documentNumberGenerator = documentNumberGenerator;
        this.userManager = userManager;
    }

    public Document createDocument(String content, String title){
        Document document = new Document(documentNumberGenerator.generate(), content, title, userManager.currentEmployee());
        return document;
    }
}
