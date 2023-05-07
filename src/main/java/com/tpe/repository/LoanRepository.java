package com.tpe.repository;

import com.tpe.domain.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class LoanRepository implements BaseRepository<Loan> {
    @Override
    public List<Loan> findAll() {
        return null;
    }

    @Override
    public Loan findById(long id) {
        return null;
    }

    @Override
    public Loan save(Loan entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Loan entity) {

    }
}
