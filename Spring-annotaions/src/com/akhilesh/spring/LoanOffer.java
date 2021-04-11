package com.akhilesh.spring;

import org.springframework.stereotype.Component;

@Component
public class LoanOffer implements Loan {

	@Override
	public String carLoan() {
		return "Loan offer in all car";
	}

	@Override
	public String homeLoan() {
		return "Loan offer in all home loan";
	}

}
