package pl.com.bottega.documentmanagement.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.com.bottega.documentmanagement.api.DocumentCriteria;
import pl.com.bottega.documentmanagement.api.DocumentDto;
import pl.com.bottega.documentmanagement.api.DocumentsCatalog;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by arkadiuszarak on 27/07/2016.
 */
//@Component
//@Service
public class JPQLDocumentsCatalog implements DocumentsCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DocumentDto get(DocumentNumber documentNumber) {
        checkNotNull(documentNumber);

        String query = "SELECT NEW pl.com.bottega.documentmanagement.api.DocumentDto(d.documentNumber.number, d.title, d.content, " +
                "d.status, d.createdAt, d.verifiedAt, d.updatedAt, d.creator.employeeId.id, d.verificator.employeeId.id) FROM Document d " +
                "WHERE d.documentNumber.number = ?1";


        return entityManager.createQuery(query, DocumentDto.class).setParameter(1, documentNumber.getNumber()).getSingleResult();
    }

    @Override
    public Iterable<DocumentDto> find(DocumentCriteria documentCriteria) {
        checkNotNull(documentCriteria);
        return null;
    }
}
