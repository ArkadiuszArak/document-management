package pl.com.bottega.documentmanagement.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.events.DocumentListener;

import java.util.Collection;

/**
 * Created by arkadiuszarak on 27/08/2016.
 */
public class DocumentListenerManager {

    private Collection<DocumentListener> listeners;

    public DocumentListenerManager(Collection<DocumentListener> listeners) {

        this.listeners = listeners;
    }

    public void subscribeListener(Document document){
        for (DocumentListener d: listeners)
            document.subscribeDocumentListener(d);
        //listeners.forEach(document :: subscribeDocumentListener);
    }
}
