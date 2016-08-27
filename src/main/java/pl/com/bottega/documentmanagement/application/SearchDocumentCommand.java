package pl.com.bottega.documentmanagement.application;

/**
 * Created by arkadiuszarak on 21/08/2016.
 */
public class SearchDocumentCommand extends SpringCommand {
    @Override
    public void execute() {
        System.out.println("Search document");
    }
}
