package com.tpe.controller;

import com.tpe.domain.Loan;
import com.tpe.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/new")
    public String sendLoanForm(@ModelAttribute("loan") Loan loan) {
        return "loanForm";
    }

    @PostMapping("/saveLoan")
    public String createLoan(@ModelAttribute Loan loan) {
        loanService.saveLoan(loan);
        return "redirect:/loans";
    }

    @GetMapping
    public ModelAndView getLoans(){
        List<Loan> list = loanService.getAllLoans();
        ModelAndView mav = new ModelAndView();
        mav.addObject("loans",list);
        mav.setViewName("loans");
        return mav;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Loan loan = loanService.findLoanById(id);
        model.addAttribute(loan);
        return "loanForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteLoan(@PathVariable Long id){
        loanService.deleteLoan(id);
        return "redirect:/loans";
    }
}
