package pl.com.bottega.documentmanagement.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.api.DocumentCriteria;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.repositories.DocumentRepository;



//@Repository
public class FakeDocumentRepository implements DocumentRepository {
    @Override
    public void save(Document document) {
        System.out.println("Save document");
    }

    @Override
    public Document load(DocumentNumber documentNumber) {
        System.out.println("Load document");
        return null;
    }
}
