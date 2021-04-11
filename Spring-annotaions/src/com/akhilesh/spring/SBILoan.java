package com.akhilesh.spring;

import org.springframework.stereotype.Component;

@Component
public class SBILoan implements Loan{

	@Override
	public String carLoan() {
		return null;
	}

	@Override
	public String homeLoan() {
		
		return null;
	}

}
