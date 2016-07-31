package pl.com.bottega.documentmanagement.infrastructure;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.documentmanagement.api.DocumentCriteria;
import pl.com.bottega.documentmanagement.api.DocumentDto;
import pl.com.bottega.documentmanagement.api.DocumentSearchResults;
import pl.com.bottega.documentmanagement.api.DocumentsCatalog;
import pl.com.bottega.documentmanagement.domain.*;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by arkadiuszarak on 31/07/2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/application.xml")
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
@Sql("/fixtures/document.sql")
public class JPADocumentCatalogTest {

    @Autowired
    private DocumentsCatalog jpaDocumentsCatalog;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void shouldFindDocumentByStatus(){
        //given
        Employee employee = new Employee("test", "test", new EmployeeId(10L));
        Document document = new Document(new DocumentNumber("1"), "draft", "draft" , employee);
        Document documentVerified = new Document(new DocumentNumber("2"), "verified", "verified" , employee);
        entityManager.persist(employee);
        entityManager.persist(document);
        documentVerified.verify(employee);
        entityManager.persist(documentVerified);
        //when
        DocumentCriteria documentCriteria = new DocumentCriteria();
        documentCriteria.setPageNumber(1L);
        documentCriteria.setPerPage(25L);
        documentCriteria.setStatus(DocumentStatus.DRAFT);

        DocumentSearchResults result = jpaDocumentsCatalog.find(documentCriteria);

        //then
        assertEquals(new Long(1), result.getTotalPages());
        List<DocumentDto> documents = Lists.newArrayList(result.getDocuments());
        assertEquals(1, documents.size());
        DocumentDto documentDto = documents.get(0);
        assertEquals("draft", documentDto.getContent());
        assertEquals("DRAFT", documentDto.getStatus());
    }


}
