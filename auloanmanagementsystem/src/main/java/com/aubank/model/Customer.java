package com.aubank.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

// https://chatgpt.com/c/69088dd3-2c18-8323-a4bb-6e0a9958f277
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    private String customerFirstName;

    private String customerLastName;

    private String customerAddress;

    private String customerGender;

    @Column(unique = true)
    private long customerAdharNumber;

    @Column(unique = true)
    private String customerPanNumber;

    private Date customerDOB;

    @Column(unique = true)
    private long customerContactNumber;

    @Column(unique = true)
    private String customerEmailId;

    private String customerPassword;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Loan> loans;


}
