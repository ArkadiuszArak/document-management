package pl.com.bottega.documentmanagement.controller;

import pl.com.bottega.documentmanagement.domain.DocumentNumber;

/**
 * Created by arkadiuszarak on 03/07/2016.
 */
public class DocumentRequest {
    private String title;
    private String content;
    private DocumentNumber documentNumber;

    public void setDocumentNumber(DocumentNumber documentNumber) {
        this.documentNumber = documentNumber;
    }

    public DocumentNumber getDocumentNumber() {

        return documentNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
