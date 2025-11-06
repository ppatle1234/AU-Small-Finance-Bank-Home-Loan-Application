package com.aubank.controller;

import com.aubank.model.Document;
import com.aubank.service.IDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final IDocumentService iDocumentService;

    @PostMapping(value = "/upload/{loanId}", consumes = "multipart/form-data")
    public ResponseEntity<Document> uploadDocument(@PathVariable long loanId,   @RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(iDocumentService.uploadFile(loanId, file), HttpStatus.CREATED);
    }

    @GetMapping("/findalldocuments")
    public ResponseEntity<List<Document>> findAll(){
        return new ResponseEntity<>(iDocumentService.getALlDocument(), HttpStatus.OK);
    }
}
