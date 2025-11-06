package com.aubank.service;

import com.aubank.model.Loan;
import com.aubank.model.LoanStatus;

import java.util.List;

public interface ILoanService {

    Loan applyLoan(long customerId, Loan loan);

    List<Loan> getAllLoan();

    Loan changeStatus(long loanId, LoanStatus status, String approver);


}
