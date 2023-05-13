package com.tpe.service;

import com.tpe.domain.Loan;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanRepository repository;

    @Override
    public List<Loan> getAllLoans() {
        return repository.getAll();
    }

    @Override
    public Loan findLoanById(Long id) {
        Loan loan = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("İstenilen id'li Loan objesi bulunamadı : " + id));
        return loan;
    }

    @Override
    public void saveLoan(Loan loan) {
        repository.save(loan);
    }

    @Override
    public void updateLoan(Loan loan) {
        repository.update(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        repository.delete(id);
    }
}
