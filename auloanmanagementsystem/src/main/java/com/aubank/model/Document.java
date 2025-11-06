package com.aubank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOCUMENT")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long documentId;

    private String documentName;

    private String documentType;

    private String documentUrl;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    @JsonBackReference
    private Loan loan;

}
