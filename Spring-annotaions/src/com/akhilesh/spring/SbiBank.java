package com.akhilesh.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("sbiBankAccount")
@Component
//@Scope(scopeName ="prototype" )
public class SbiBank implements Account {

	@Autowired
	@Qualifier("LoanABC")
	private Loan loan;

	public SbiBank() {
	
		System.out.println("SBI Bank default constructor");
	}
	/*
	 * @Autowired public SbiBank(Loan loan) { this.loan = loan; }
	 */

	/*
	@Autowired
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	*/

	@Override
	public void savingAccount() {

		System.out.println("Saving account of SBI Bank");
	}

	@Override
	public void currentAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pfAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void epfAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void salaryAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public String carLoan() {
		return loan.carLoan();
	}

	@Override
	public String homeLoan() {
		return loan.homeLoan();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Post Contructor");
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("Pre Destroyer");
	}

}
