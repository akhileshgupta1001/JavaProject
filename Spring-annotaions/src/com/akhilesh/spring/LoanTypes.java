package com.akhilesh.spring;

import org.springframework.stereotype.Component;

@Component("LoanABC")
public class LoanTypes implements Loan {

	@Override
	public String carLoan() {
		return "Nano car loan offer";
	}

	@Override
	public String homeLoan() {
		return "Home Loan ";
	}

}
