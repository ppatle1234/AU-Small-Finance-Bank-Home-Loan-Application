package com.aubank.controller;

import com.aubank.model.Customer;
import com.aubank.model.Loan;
import com.aubank.model.LoanStatus;
import com.aubank.service.ILoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final ILoanService iLoanService;

    @PostMapping("/apply/{customerId}")
    public ResponseEntity<Loan> applyLoan(@PathVariable long customerId, @RequestBody Loan loan){
        return new ResponseEntity<>(iLoanService.applyLoan(customerId, loan), HttpStatus.CREATED);
    }

    @GetMapping("/findallloans")
    public ResponseEntity<List<Loan>> findAll(){
        return new ResponseEntity<>(iLoanService.getAllLoan(), HttpStatus.OK);
    }

    @PutMapping("/status/{loanId}")
    public ResponseEntity<Loan> updateStatus(@PathVariable long loanId, @RequestParam("status")LoanStatus loanStatus, @RequestParam("approver")String approverer){

        return new ResponseEntity<>(iLoanService.changeStatus(loanId, loanStatus, approverer), HttpStatus.CREATED);
    }
}
