package com.servletsController;

import com.servlets.dao.DAOCurrentAccount;
import com.servlets.dao.DAOUser;
import com.servlets.model.CurrentAccount;
import com.servlets.model.UserAuth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CurrentAccountTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CurrentAccountTask() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAuth user = (UserAuth) session.getAttribute("user");
		DAOCurrentAccount daoCur = new DAOCurrentAccount();
		DAOUser daoUser = new DAOUser();
		CurrentAccount currentAccount = daoCur.getCurrentAccount(user.getAccountNumber());

		String transaction = request.getParameter("transaction");
		double amount = Double.parseDouble(request.getParameter("amount"));
		int duration = Integer.parseInt(request.getParameter("duration"));
		boolean check = false;
		double getMoney = 0;

		if (transaction.equalsIgnoreCase("deposit")) {
			check = currentAccount.deposit(amount);
			daoCur.updateTransaction(currentAccount.getAcc_no(), currentAccount.getAcc_no(), amount, "deposit");
		} else if (transaction.equalsIgnoreCase("withdraw")) {
			getMoney = currentAccount.withdraw(amount);
			check = true;
		} else if (transaction.equalsIgnoreCase("transfer")) {
			int orther_acc_id = Integer.parseInt(request.getParameter("to-customer-id"));

			UserAuth otherUser = daoUser.getUser(orther_acc_id);
			CurrentAccount orther_acc = daoCur.getCurrentAccount(otherUser.getAccountNumber());

			orther_acc.deposit(amount);
			currentAccount.withdraw(amount);
			daoCur.updateCurrentAccount(orther_acc);
			daoCur.updateTransaction(currentAccount.getAcc_no(), orther_acc.getAcc_no(), amount, "transfer");
			check = true;
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}

		daoCur.updateCurrentAccount(currentAccount);

		request.setAttribute("action", transaction.toUpperCase());
		request.setAttribute("status", check);
		request.setAttribute("money", getMoney);
		request.getRequestDispatcher("status.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
