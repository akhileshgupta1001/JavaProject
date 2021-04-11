package com.akhilesh.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoationBenScope {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		// Account account = context.getBean("sbiBankAccount", Account.class);
		Account account = context.getBean("sbiBank", Account.class);

		Account account2 = context.getBean("sbiBank", Account.class);

		boolean result = account == account2;

		if (result)
			System.out.println("Scope is siglton");
		else
			System.out.println("Scope is not siglton");

		account.savingAccount();
		System.out.println(account.carLoan());
		System.out.println(account.homeLoan());
		context.close();

	}

}
