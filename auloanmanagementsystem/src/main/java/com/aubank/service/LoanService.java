package com.aubank.service;

import com.aubank.exception.RecordNotFoundException;
import com.aubank.model.Customer;
import com.aubank.model.Loan;
import com.aubank.model.LoanStatus;
import com.aubank.repository.CustomerRepository;
import com.aubank.repository.LoanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService implements ILoanService{

    private final CustomerRepository customerRepository;

    private final LoanRepository loanRepository;

    @Override
    public Loan applyLoan(long customerId, Loan loan) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RecordNotFoundException("Customer Not Found"));

        loan.setCustomer(customer);
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoan() {
        return loanRepository.findAll();
    }

    @Override
    @Transactional
    public Loan changeStatus(long loanId, LoanStatus status, String approver) {

        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RecordNotFoundException("Loan Not Found"));

        loan.setLoanStatus(status);
        loan.setApprover(approver);
        return loanRepository.save(loan);
    }

}
