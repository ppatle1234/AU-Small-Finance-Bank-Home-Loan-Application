package com.aubank.service;

import com.aubank.exception.RecordNotFoundException;
import com.aubank.model.Document;
import com.aubank.model.Loan;
import com.aubank.repository.DocumentRepository;
import com.aubank.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService implements IDocumentService{

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final LoanRepository loanRepository;

    private final DocumentRepository documentRepository;

    @Override
    public Document uploadFile(long loanId, MultipartFile multipartfile) throws IOException {

        Loan loan = loanRepository.findById(loanId).orElseThrow(()-> new RecordNotFoundException("Loan Not Found."));

        // sanitize filename, create directories
        String original = StringUtils.cleanPath(multipartfile.getOriginalFilename());
        String filename = System.currentTimeMillis() + "-" + original;

        /// create upload directory if not exists
        Path target = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(target);

        // save file
        Path filePath = target.resolve(filename);
        Files.copy(multipartfile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // build document entity
        Document doc = new Document();
        doc.setDocumentName(original);
        doc.setDocumentType(FilenameUtils.getExtension(original));
        // If serving statically, create URL, e.g. /files/{filename}; here store path
        doc.setDocumentUrl("/uploads/" + filename);
        doc.setLoan(loan);
        return documentRepository.save(doc);
    }

    @Override
    public List<Document> getALlDocument() {
        return documentRepository.findAll();
    }
}
