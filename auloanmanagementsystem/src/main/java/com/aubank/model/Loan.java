package com.aubank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOAN")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;

    private String loanType;

    private double loanAmount;

    private String approver;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus = LoanStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Document> documents;


}
