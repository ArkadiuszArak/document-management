package pl.com.bottega.documentmanagement.api;

import org.junit.Test;
import org.mockito.Mock;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.DocumentNumberGenerator;
import pl.com.bottega.documentmanagement.domain.repositories.DocumentRepository;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DocumentFlowProcessTest {

    private String anyContent = "test content";
    private String anyTitle = "title";

    @Mock
    private DocumentFactory documentFactory;

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private UserManager userManager;

    @Mock
    private Document document;

    @Mock
    private DocumentNumberGenerator documentNumberGenerator;

    @Test
    public void shouldCreateDocument(){
        DocumentFlowProcess documentFlowProcess = new DocumentFlowProcess(documentRepository, userManager, documentNumberGenerator, documentFactory);
        when(documentFactory.createDocument(anyContent, anyTitle)).thenReturn(document);

        DocumentNumber documentNumber = documentFlowProcess.create(anyTitle, anyContent);

        verify(documentRepository).save(document);
        assertNotNull(documentNumber.getNumber());
    }
}
