package com.servletsController;

import com.servlets.dao.DAOUser;
import com.servlets.model.UserAuth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		DAOUser dao = new DAOUser();
		UserAuth user;

		int id = Integer.parseInt(request.getParameter("id"));
		String pass = request.getParameter("password");

		if (dao.checkUserAuth(id, pass)) {
			try {
				boolean flag = dao.checkIsNewUser(id);
				if (flag) {
					session.setAttribute("id", id);
					request.getRequestDispatcher("change_password.jsp").forward(request, response);
				} else {
					user = dao.getUser(id);
					session.setAttribute("user", user);
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}
}
