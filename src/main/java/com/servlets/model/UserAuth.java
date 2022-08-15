package com.servlets.model;

public class UserAuth {
	private String password;
	private int customerId;
	private int userId;

	private String cusName;
	private String cusAddress;
	private int cusPhoneNumber;
	private int account_number;

	public UserAuth() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public int getCusPhoneNumber() {
		return cusPhoneNumber;
	}

	public void setCusPhoneNumber(int cusPhoneNumber) {
		this.cusPhoneNumber = cusPhoneNumber;
	}
        
        public void setAccountNumber(int account_number) {
		this.account_number = account_number;
	}
        
	public int getAccountNumber() {
		return account_number;
	}

	
}
