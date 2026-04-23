package com.loan.sbeans;

public interface LoanService {
//	String applyLoan();
//	String rejectLoan();
//	void viewLoan();
	
	    void applyLoan(String applicantName, double amount);
	    void rejectLoan(int loanId);
	    void viewAllLoans();
	
}
