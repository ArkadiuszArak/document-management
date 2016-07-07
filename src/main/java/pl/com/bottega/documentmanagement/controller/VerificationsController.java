package pl.com.bottega.documentmanagement.controller;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.documentmanagement.api.DocumentFlowProcess;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;

/**
 * Created by arkadiuszarak on 06/07/2016.
 */
@RestController
@RequestMapping("/documents/{id}/verification")
public class VerificationsController {

    private DocumentFlowProcess documentFlowProcess;

    public VerificationsController(DocumentFlowProcess documentFlowProcess) {
        this.documentFlowProcess = documentFlowProcess;
    }

    @PutMapping
    public void create(@PathVariable DocumentNumber documentId){
        documentFlowProcess.verify(documentId);
    }
}
