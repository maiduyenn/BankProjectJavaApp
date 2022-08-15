package com.servlets.model;

public class Transaction {
	private int trans_id;
	private int from_account;
	private int to_account;
	private double amount;
	private String action;
	private String date;

	public Transaction() {
		super();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public int getFrom_account() {
		return from_account;
	}

	public void setFrom_account(int from_account) {
		this.from_account = from_account;
	}

	public int getTo_account() {
		return to_account;
	}

	public void setTo_account(int to_account) {
		this.to_account = to_account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
