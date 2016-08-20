package pl.com.bottega.documentmanagement.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.DocumentNumberGenerator;
import pl.com.bottega.documentmanagement.domain.repositories.DocumentRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentFlowProcessTest {

    @Mock
    private DocumentRepository documentRepository;

    private String anyContent = "test content";
    private String anyTitle = "title";
    private String newTitle = "new title";

    private String newContent = "new content";

    @Mock
    private DocumentFactory documentFactory;

    @Mock
    private UserManager userManager;

    @Mock
    private Document document;

    @Mock
    private DocumentNumberGenerator documentNumberGenerator;

    @Mock
    private DocumentNumber documentNumber;

    @Test
    public void shouldCreateDocument() {
        DocumentFlowProcess documentFlowProcess = new DocumentFlowProcess(documentRepository, userManager, documentNumberGenerator, documentFactory);
        when(documentFactory.createDocument(anyContent, anyTitle)).thenReturn(document);
        when(document.number()).thenReturn(documentNumber);

        DocumentNumber documentNr = documentFlowProcess.create(anyTitle, anyContent);

        verify(documentRepository).save(document);
        assertNotNull(documentNr.getNumber());
    }

/*    @Test
    public void shouldChangeTitleAndContent(){
        DocumentFlowProcess documentFlowProcess = new DocumentFlowProcess(documentRepository, userManager, documentNumberGenerator, documentFactory);
        when(documentFactory.createDocument(anyContent, anyTitle)).thenReturn(document);
        when(documentRepository.load(document.number())).thenReturn(document);

        documentFlowProcess.change(document.number(), newTitle, newContent);

        verify(documentRepository).save(document);
        assertEquals(newTitle, document.title());
    }*/
}
