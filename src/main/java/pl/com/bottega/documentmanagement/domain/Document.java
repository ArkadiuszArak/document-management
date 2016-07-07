package pl.com.bottega.documentmanagement.domain;

import pl.com.bottega.documentmanagement.api.DocumentDto;

import javax.persistence.*;

/**
 * Created by maciuch on 12.06.16.
 */
@Entity
public class Document {

    @Id
    @GeneratedValue
    private Long id;
    private DocumentNumber documentNumber;
    private String content;
    private String title;
    @Enumerated(EnumType.ORDINAL)
    private DocumentStatus documentStatus;

    @ManyToOne
    private Employee creator;

    @ManyToOne
    private Employee verificator;

    private Document() {
    }

    public Document(DocumentNumber documentNumber, String content, String title, Employee crator, DocumentStatus documentStatus) {

        this.documentNumber = documentNumber;
        this.content = content;
        this.title = title;
        this.creator = crator;
        this.documentStatus = documentStatus;
    }

    public void change(String title, String content) {
        this.title = title;
        this.content = content;
        this.documentStatus = DocumentStatus.DRAFT;
    }

    public void verify(Employee employee) {
        this.verificator = employee;
        this.documentStatus = DocumentStatus.VERIFIED;
    }

    public void confirm(Employee conirmator) {

    }

    public void confirm(Employee confirmator, Employee forEmployee) {

    }

}
