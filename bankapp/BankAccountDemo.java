package com.maveric.bankapp;

import java.util.List;
import java.util.Scanner;

public class BankAccountDemo {

	static void showMenu(BankAccount bankAccount) throws BankException {
		System.out.println("Welcome Account Number: " + bankAccount.getAccountNumber() + " \nAccount Type "
				+ bankAccount.getType());
		boolean flag = true;
		while (flag) {
			System.out.println("Please Select an option below: ");
			System.out.println("Press 1 to Deposit Amount.");
			System.out.println("Press 2 to Withdraw Amount.");
			System.out.println("Press 3 to TransactionHistory");
			System.out.println("Press 4 to Get Mini Statement");
			System.out.println("Press 5 to Get Minimum Balance");
			System.out.println("Press 6 to Get Current Balance");
			System.out.println("Press 7 to Get Interest Rate");
			System.out.println("Press any key to Exit");
			System.out.println(" ");

			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Please Enter the amount to be deposited: ");
				double depamt = scanner.nextDouble();
				bankAccount.deposit(depamt);
				break;
			case 2:
				System.out.println("Please Enter the amount to withdraw:");
				double withamt = scanner.nextDouble();
				bankAccount.withdraw(withamt);
				break;
			case 3:
				System.out.println("Transaction History:");
				List<Transaction> transhist = bankAccount.getTransactionHistory();
				transhist.stream().forEach(System.out::println);
				break;
			case 4:
				System.out.println("Mini Statement");
				List<Transaction> ministmt = bankAccount.getMiniStatement();
				ministmt.stream().forEach(System.out::println);
				break;
			case 5:
				System.out.println("Minimum Balance");
				System.out.println(bankAccount.getMinimumBalance());
				break;
			case 6:
				System.out.println("Your Account Balance is " + bankAccount.getCurrentBalance() + " Rupees");
				System.out.println(" ");
				break;
			case 7:
				System.out.println("Interest Rate is: " + bankAccount.getInterestRate());
				break;
			default:
				System.out.println("Transaction Ended");
				flag = false;
				break;
			}
		}
	}

	public static void main(String args[]) throws BankException {

		int option;
		HeadOffice headOffice = new HeadOffice();
		headOffice.createBranch("Branch0");

		headOffice.createBranch("Branch1");

		Customer c1 = new Customer();
		c1.setPanNumber("LKJH651V");

		Branch b1 = headOffice.getBranchById("1");
		// BankAccount bankAccount = new SavingAccount();

		b1.createBankAccount("LKJH651V", "Saving", 10000.0);
		// b1.createBankAccount("ANDSK12", "Current", 50000.0);
		// c1.setBankAccounts();
		// System.out.println(headOffice.getAllBranches().toString());

		BankAccount currAcno = b1.getAccountByAccountNumber("1");
		showMenu(currAcno); // to test for cur account
	}
}