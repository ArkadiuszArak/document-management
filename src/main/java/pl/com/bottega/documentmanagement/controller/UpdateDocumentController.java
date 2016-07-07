package pl.com.bottega.documentmanagement.controller;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.documentmanagement.api.DocumentFlowProcess;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;

/**
 * Created by arkadiuszarak on 05/07/2016.
 */
@RestController
@RequestMapping("/documents/{documentId}")
public class UpdateDocumentController {

    private DocumentFlowProcess documentFlowProcess;

    public UpdateDocumentController(DocumentFlowProcess documentFlowProcess) {
        this.documentFlowProcess = documentFlowProcess;
    }

    @PostMapping
    public void update(@PathVariable DocumentNumber documentId, @RequestBody DocumentRequest documentRequest){
        DocumentNumber documentNumber = new DocumentNumber(documentId.getNumber());
        documentFlowProcess.change(documentNumber, documentRequest.getTitle(), documentRequest.getContent());
    }
}