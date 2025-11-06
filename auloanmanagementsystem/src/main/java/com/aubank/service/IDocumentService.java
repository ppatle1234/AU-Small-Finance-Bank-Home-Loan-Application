package com.aubank.service;

import com.aubank.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IDocumentService {

    Document uploadFile(long loanId, MultipartFile multipartFile) throws IOException;

    List<Document> getALlDocument();
}
