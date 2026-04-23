package com.loan.sbeans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.loan.exception.InvalidLoanOperationException;
import com.loan.exception.LoanProcessingException;

@Component("hdfc")
public final class HDFCService implements LoanService {

    private final String branchCode = "HDFC001";
    private final double interestRate = 8.5;
    private final String managerName = "Ramesh";
  //                   id       name
    private final Map<Integer, String> loans = new HashMap<>();
    private int idCounter = 1;// unique id for each new customer , 

    @Override
    public void applyLoan(String name, double amount) {
        if (amount <= 0) {
            throw new LoanProcessingException("Invalid loan amount");
        }
        loans.put(idCounter, name + " - ₹" + amount);
        System.out.println("HDFC Loan Approved ID: " + idCounter++);
    }

    @Override
    public void rejectLoan(int loanId) {
        if (!loans.containsKey(loanId)) {
            throw new InvalidLoanOperationException("Loan not found");
        }
        loans.remove(loanId);
        System.out.println("HDFC Loan Rejected ID: " + loanId);
    }

    @Override
    public void viewAllLoans() {
        System.out.println("HDFC Loans: " + loans);
    }
}