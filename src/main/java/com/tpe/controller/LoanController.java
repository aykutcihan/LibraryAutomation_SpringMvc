package com.tpe.controller;

import com.tpe.domain.Loan;
import com.tpe.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.findAll();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable long id) {
        return loanService.findById(id);
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.save(loan);
    }

    @PutMapping("/{id}")
    public void updateLoan(@PathVariable long id, @RequestBody Loan loan) {
        loanService.update(loan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable long id) {
        loanService.delete(id);
    }
}
