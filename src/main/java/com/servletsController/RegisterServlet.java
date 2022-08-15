package com.servletsController;

import com.servlets.dao.DAOCurrentAccount;
import com.servlets.dao.DAOUser;
import com.servlets.model.UserAuth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");

		String name = request.getParameter("customer-name");
		String address = request.getParameter("customer-address");
		int phone = Integer.parseInt(request.getParameter("customer-phone"));

		try {
			DAOUser dao_user = new DAOUser();
			DAOCurrentAccount dao_cur = new DAOCurrentAccount();
			
			UserAuth user = dao_user.getUser(id);
			user = dao_user.getUpdateUser(user, name, address, phone);
			dao_user.updateUser(id, user);
			dao_cur.createNewAccount(user.getAccountNumber(), new Random().nextInt(10000000), 0);
			
			session.setAttribute("user", user);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
