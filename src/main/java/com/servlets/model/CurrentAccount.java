package com.servlets.model;

public class CurrentAccount extends AccountDetails {
	private double serviceCharge;
	private String chequeBook;

	public CurrentAccount() {
		super();
	}

	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getChequeBook() {
		return chequeBook;
	}

	public void setChequeBook(String chequeBook) {
		this.chequeBook = chequeBook;
	}

	public boolean issueCheque() {
		if (super.getAccBalance() <= 10000000) {
			return true;
		}
		return false;
	}

	public void imposePenalty() {
		if (issueCheque()) {
			this.serviceCharge = 50000;
		} else {
			this.serviceCharge = 0;
		}
	}

	@Override
	public boolean deposit(double amount) {
		if (amount > 0) {
			super.setAccBalance(amount + super.getAccBalance());
			return true;
		}
		return false;
	}

	@Override
	public double withdraw(double amount) {
		double restAmount = super.getAccBalance() - amount;
		if (amount < this.serviceCharge || super.getAccBalance() < amount) {
			return 0;
		} else {
			super.setAccBalance(restAmount);
			imposePenalty();
			return amount - this.serviceCharge;
		}
	}

	@Override
	public boolean transfer(CurrentAccount acc1, CurrentAccount acc2, double amount) {
		acc1.deposit(amount);
		acc2.withdraw(amount);
		return false;
	}

	@Override
	public String toString() {
		return "CurrentAccount [getAcc_no()=" + getAcc_no() + ", getAccBalance()=" + getAccBalance() + "]";
	}

}
