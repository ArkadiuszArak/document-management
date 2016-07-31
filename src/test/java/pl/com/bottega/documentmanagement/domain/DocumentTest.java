package pl.com.bottega.documentmanagement.domain;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by arkadiuszarak on 31/07/2016.
 */

//given

//when

//then
@RunWith(MockitoJUnitRunner.class)
public class DocumentTest {

    @Mock
    private DocumentNumber anyNumber;

    @Mock
    private Employee anyEmployee;

    private String anyContent = "test content";
    private String anyTitle = "test title";

    @Test
    public void shouldCreateDocumentWithInitialState(){
        //given

        //when
        Document document = new Document(anyNumber, anyContent, anyTitle, anyEmployee);
        //then
        assertEquals(anyNumber, document.number());
        assertEquals(anyContent, document.content());
        assertEquals(anyTitle, document.title());
        assertEquals(anyEmployee, document.creator());
        assertFalse(document.delete());
        assertEquals(DocumentStatus.DRAFT, document.status());
    }

    @Test
    public void shouldVerifyDocument(){
        //given
        Document document = new Document(anyNumber, anyContent, anyTitle, anyEmployee);
        //when

        document.verify(anyEmployee);
        //then
        assertEquals(DocumentStatus.VERIFIED, document.status());
        assertNotNull(document.verifiedAt());
        assertEquals(anyEmployee, document.creator());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRequireVerificator(){
        //given
        Document document = new Document(anyNumber, anyContent, anyTitle, anyEmployee);
        //when
        document.verify(null);

    }

    @Test
    public void shouldRequireVerificatorOtherWay(){
        //given
        Document document = new Document(anyNumber, anyContent, anyTitle, anyEmployee);
        try {
            //when
            document.verify(null);
        }
        catch (IllegalArgumentException ex){
            return;
        }

        fail("IllegalArgumentException");

    }
}
