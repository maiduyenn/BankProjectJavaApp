package com.servlets.dao;

import com.jdbc.Database;
import com.servlets.model.CurrentAccount;
import com.servlets.model.Transaction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DAOCurrentAccount {
	private Database db;
	private String query;
	private ResultSet rs;

	public DAOCurrentAccount() {
		super();
		db = new Database();
	}

	public void createNewAccount(int acccount_number, int current_number, int balance) {
		query = "insert into current_account (account_number,current_number,account_balance) values(" + acccount_number
				+ "," + current_number + "," + balance + ")";

		try {
			db.doExecuteUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public CurrentAccount getCurrentAccount(int acc_no) {
		CurrentAccount cur = new CurrentAccount();

		query = "select * from current_acc where acc_no=" + acc_no;

		try {
			rs = db.doExecuteQuery(query);
			while (rs.next()) {
				cur.setAccNumber(rs.getInt("acc_no"));
				cur.setAcc_no(rs.getInt("cur_no"));
				cur.setAccBalance(rs.getDouble("acc_balance"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cur;
	}

	public boolean updateCurrentAccount(CurrentAccount cur) {
		query = "update current_acc set acc_balance = " + cur.getAccBalance() + " where acc_no = " + cur.getAccNumber()
				+ " and cur_no =" + cur.getAcc_no();
		if (db.doExecuteUpdate(query)) {
			return true;
		}
		return false;
	}

	public boolean updateTransaction(int acc_number, int acc_id, double amount, String action) {
		int trans_id = new Random().nextInt(10000000);
		query = "insert into transaction (trans_id, from_acc, to_acc, amount, action, date) values(" + trans_id + ","
				+ acc_number + "," + acc_id + "," + amount + ",'" + action + "','" + new Date() + "');";
		if (db.doExecuteUpdate(query)) {
			return true;
		}
		return false;
	}

	public List<Transaction> getTransactionList(int acc_no) {
		List<Transaction> list = new ArrayList<Transaction>();
		query = "select * from transaction where from_acc = " + acc_no + " order by date";
		try {
			rs = db.doExecuteQuery(query);
			while (rs.next()) {
				Transaction trans = new Transaction();
				trans.setTrans_id(rs.getInt("trans_id"));
				trans.setFrom_account(rs.getInt("from_acc"));
				trans.setTo_account(rs.getInt("to_acc"));
				trans.setAmount(rs.getDouble("amount"));
				trans.setAction(rs.getString("action"));
				trans.setDate(rs.getString("date"));
				list.add(trans);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}
}
