package com.maveric.bankapp;

public class Transaction {
	private String transactionalId;
	private double amount;
	private String type;
	
	public String getTransactionId() {
		return transactionalId;
	}
	public void setTransactionid(String transactionId) {
		this.transactionalId = transactionId;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String TransactionType) {
		this.type = TransactionType;
	}
}
