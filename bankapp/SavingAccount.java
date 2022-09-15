package com.maveric.bankapp;

public class SavingAccount extends BankAccount{
	public static final double MINIMUM_BALANCE = 10000.0;
	public static final double INTEREST_RATE = 4.5;
	
	@Override public String getType() {
		return "Saving";
	}
	
	public double getMinimumBalance() {
		return MINIMUM_BALANCE;
	}
	
	public double getInterestRate() {
		return INTEREST_RATE;
	}
}
