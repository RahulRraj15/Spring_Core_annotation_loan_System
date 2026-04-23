package com.loan.sbeans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.loan.exception.InvalidLoanOperationException;
import com.loan.exception.LoanProcessingException;

@Component("icici")
public final class ICICIService implements LoanService {

    private final String branchCode = "ICICI002";
    private final double interestRate = 9.0;
    private final String managerName = "Suresh";

    private final Map<Integer, String> loans = new HashMap<>();
    private int idCounter = 100;

    @Override
    public void applyLoan(String name, double amount) {
        if (amount < 5000) {
            throw new LoanProcessingException("Minimum loan is 5000");
        }
        loans.put(idCounter, name + " - ₹" + amount);
        System.out.println("ICICI Loan Approved ID: " + idCounter++);
    }

    @Override
    public void rejectLoan(int loanId) {
        if (!loans.containsKey(loanId)) {
            throw new InvalidLoanOperationException("Loan not found");
        }
        loans.remove(loanId);
        System.out.println("ICICI Loan Rejected ID: " + loanId);
    }

    @Override
    public void viewAllLoans() {
        System.out.println("ICICI Loans: " + loans);
    }
}