package com.tpe.service;

import com.tpe.domain.Loan;

import java.util.List;

public interface LoanService {

    List<Loan> getAllLoans();

    Loan findLoanById(Long id);

    void saveLoan(Loan loan);

    void updateLoan(Loan loan);

    void deleteLoan(Long id);
}
