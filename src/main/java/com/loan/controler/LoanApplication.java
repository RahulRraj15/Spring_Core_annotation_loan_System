package com.loan.controler;

import com.loan.sbeans.LoanService;


public final class LoanApplication {

    private final LoanService loanService;

    
    public LoanApplication(LoanService loanService) {
        this.loanService = loanService;
    }

    public void apply(String name, double amount) {
        loanService.applyLoan(name, amount);
    }

    public void reject(int id) {
        loanService.rejectLoan(id);
    }

    public void view() {
        loanService.viewAllLoans();
    }
}