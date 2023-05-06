package com.tpe.service;

import com.tpe.domain.Loan;
import com.tpe.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("loanService")
@Scope("prototype")
public class LoanService implements BaseService<Loan>{
    private LoanRepository loanRepository;

    @Autowired
    public LoanService(@Qualifier ("loanRepository") LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan findById(long id) {
        return loanRepository.findById(id);
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void delete(long id) {
        loanRepository.delete(id);

    }

    @Override
    public void update(Loan loan) {
        loanRepository.update(loan);

    }
}
