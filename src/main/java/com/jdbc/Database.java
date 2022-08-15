package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	JDBCConnector jdbc;
	Connection con;
	Statement st;
	ResultSet rs;

	public Database() {
		super();
		this.jdbc = new JDBCConnector();
		this.con = this.jdbc.getCon();
	}

	public ResultSet doExecuteQuery(String query) {
		try {
			st = this.con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return this.rs;
	}

	public void doQuery(String query) {
		try {
			st = this.con.createStatement();
			st.execute(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean doExecuteUpdate(String query) {
		try {
			st = this.con.createStatement();
			int i = st.executeUpdate(query);
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
