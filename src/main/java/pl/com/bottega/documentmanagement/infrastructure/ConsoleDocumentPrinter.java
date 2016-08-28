package pl.com.bottega.documentmanagement.infrastructure;

import pl.com.bottega.documentmanagement.domain.DocumentBuilder;

import java.util.Date;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class ConsoleDocumentPrinter implements DocumentBuilder {
    @Override
    public void start() {

    }

    @Override
    public void addTitle(String title) {
        System.out.println("Title " + title);
    }

    @Override
    public void addContent(String content) {
        System.out.println("Content " + content);
    }

    @Override
    public void addCreatedAt(Date createdAt) {
        System.out.println(createdAt);
    }

    @Override
    public void addStatus(String status) {
        System.out.println("status " + status);
    }

    @Override
    public void end() {

    }
}
