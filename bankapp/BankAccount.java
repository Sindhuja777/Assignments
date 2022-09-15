package com.maveric.bankapp;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BankAccount {
	private String accountNumber;
	private double minimumBalance;
	private double currentBalance;
	private double interestRate;
	private List<Transaction> transactions;
	
	private static AtomicInteger TRANSACTION_ID_GENERATOR = new AtomicInteger(0);
	
	public void widthdraw(double amount) throws BankException{
		if(this.getType().equals("Saving")) {
			if((currentBalance - amount) < SavingsAccount.MINIMUM_BALANCE ) {
                throw new BankException("Unable to withdraw, Please maintain minimum balance always: "+ currentBalance);
            }
        }else{
            if ((currentBalance - amount) < CurrentAccount.MINIMUM_BALANCE){
                throw new BankException("Unable to withdraw, Please maintain minimum balance always: "+ currentBalance);
            }
        }

        synchronized (this){
            currentBalance -= amount;
            Transaction transaction = new Transaction();
            String transactionId = "(withdraw)" + TRANSACTION_ID_GENERATOR.incrementAndGet();
            transaction.setTransactionid(transactionId);
            transaction.setAmount(amount);
            transaction.setType("withdraw");
            addToTransactions(transaction);
        }
	}
	
	public void addToTransactions(Transaction transaction) {
		if(transactions == null) {
			transactions = new ArrayList<>(); 
		}
		transactions.add(transaction);
	}
	
	public void deposit(double amount) throws BankException {
        if (amount < 0){
            throw new BankException("Deposit amount should be greater than 0, deposit amount: "+ amount);
        }
        synchronized (this){
            currentBalance +=amount;
            Transaction transaction = new Transaction();
            String transactionId = "(deposit)" + TRANSACTION_ID_GENERATOR.incrementAndGet();
            transaction.setTransactionid(transactionId);
            transaction.setType("deposit");
            transaction.setAmount(amount);
            addToTransactions(transaction);
        }
	}
	public List<Transaction> getTransactionHistory() {
		return transactions;
	}
	public List<Transaction> getMiniStatement() {
        List<Transaction> miniStatement = new ArrayList<>();
        int count = 0;
        ListIterator<Transaction> listIterator = transactions.listIterator(transactions.size());
        while (listIterator.hasPrevious()){
            miniStatement.add(listIterator.previous());
            count++;
            if (count > 10){
                break;
            }
        }
        return miniStatement;	
	}
	
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	abstract public String getType();
}
