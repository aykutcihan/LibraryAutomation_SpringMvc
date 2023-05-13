package com.tpe.repository;

import com.tpe.domain.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {

    List<Loan> getAll();

    Optional<Loan> findById(Long id);

    void save(Loan loan);

    void update(Loan loan);

    void delete(Long id);
}
