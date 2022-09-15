package com.maveric.bankapp;

public class CurrentAccount extends BankAccount{
	
	public static final double MINIMUM_BALANCE = 20000.0;
	public static final double INTEREST_RATE = 0.0;
	
	
	public double getMinimumBalance() {
		return MINIMUM_BALANCE;
	}
	
	public double getInterestRate() {
		return INTEREST_RATE;
	}
	
	@Override public String getType() {
		return "Current";
	}
}
