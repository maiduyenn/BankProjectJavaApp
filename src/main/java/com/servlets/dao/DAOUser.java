package com.servlets.dao;

import com.jdbc.Database;
import com.servlets.model.UserAuth;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUser {
	private UserAuth user;
	private Database db;
	private String query;
	private ResultSet rs;

	public DAOUser() {
		super();
		user = new UserAuth();
		db = new Database();
	}

	public boolean checkIsNewUser(int id) {
		try {
			query = "select isNew from user_auth where customer_id = " + id + " or user_id =" + id;
			rs = db.doExecuteQuery(query);
			if (rs.next()) {
				String isNew = rs.getString("isNew");
				if (isNew.equalsIgnoreCase("yes")) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean checkUserAuth(int id, String password) {
		query = "select password from user_auth where customer_id = " + id + " or user_id =" + id;
		rs = db.doExecuteQuery(query);

		try {
			if (rs.next()) {
				String pass = rs.getString("password");
				if (pass.equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public UserAuth getUser(int id) {

		try {
			query = "select * from user_auth where customer_id =" + id + " or user_id =" + id;
			rs = db.doExecuteQuery(query);

			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setCustomerId(rs.getInt("customer_id"));
				user.setPassword(rs.getString("password"));
				user.setCusName(rs.getString("name"));
				user.setCusAddress(rs.getString("address"));
				user.setCusPhoneNumber(rs.getInt("phone"));
				user.setAccountNumber(rs.getInt("account_number"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public void updateUser(int id, UserAuth user) {
		try {
			query = "UPDATE user_auth SET password='" + user.getPassword() + "', name = '" + user.getCusName()
					+ "', address = '" + user.getCusAddress() + "',phone = '" + user.getCusPhoneNumber()
					+ "',isNew='no',account_number =" + user.getAccountNumber() + " WHERE customer_id = " + id + " or user_id =" + id;

			db.doQuery(query);
			if (!rs.next()) {
				System.out.println("update successfully!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public UserAuth getUpdateUser(UserAuth user, String name, String address, int phone) {
		user.setCusName(name);
		user.setCusAddress(address);
		user.setCusPhoneNumber(phone);
		
		return user;
	}
}
