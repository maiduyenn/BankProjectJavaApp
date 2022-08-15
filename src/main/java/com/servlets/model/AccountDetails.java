package com.servlets.model;

public abstract class AccountDetails {
	private int accNumber;
	private int acc_no;
	private String accType;
	private double accBalance;
	private String transaction;
	private String date;

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public abstract boolean deposit(double amount);

	public abstract double withdraw(double amount);

	public abstract boolean transfer(CurrentAccount acc1, CurrentAccount acc2,double amount);
}
