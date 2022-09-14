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
		if(this.getType().equals(BankAccountType.SAVINGS.toString())) {
			if((currentBalance-amount) < BankConstants.SAVING_ACCOUNT_MINIMUM_BALANCE) {
                throw new BankException("Unable to withdraw, Please maintain minimum balance always: "+ currentBalance);
            }
        }else{
            if ((currentBalance - amount) < BankConstants.CURRENT_ACCOUNT_MINIMUM_BALANCE){
                throw new BankException("Unable to withdraw, Please maintain minimum balance always: "+ currentBalance);
            }
        }

        synchronized (this){
            currentBalance -= amount;
            Transaction transaction = new Transaction();
            String transactionId = BankConstants.WITHDRAW_OPERATION + TRANSACTION_ID_GENERATOR.incrementAndGet();
            transaction.setTransactionid(transactionId);
            transaction.setAmount(amount);
            transaction.setType(TransactionType.WITHDRAW);
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
            String transactionId = "\" + TRANSACTION_ID_GENERATOR.incrementAndGet();
            transaction.setTransactionid(transactionId);
            transaction.setType(TransactionType.DEPOSIT);
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
