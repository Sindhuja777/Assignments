package com.maveric.bankapp;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private List<BankAccount> accounts;
	private String panNumber;
	
	public List<BankAccount> getBankAccounts() {
		return accounts;
	}
	
	public String getPanNumber() {
		return panNumber;
	}
	
	public void setBankAccounts(BankAccount bankAccount) {
		if(accounts == null) {
			accounts = new ArrayList<>();
		}
		accounts.add(bankAccount);
	}
	
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
}
