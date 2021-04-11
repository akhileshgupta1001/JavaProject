package com.akhilesh.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LauncherAnnoation {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		//Account account = context.getBean("sbiBankAccount", Account.class);
		Account account = context.getBean("sbiBank", Account.class);

		account.savingAccount();
		System.out.println(account.carLoan());
		System.out.println(account.homeLoan());
		context.close();
	}
}
