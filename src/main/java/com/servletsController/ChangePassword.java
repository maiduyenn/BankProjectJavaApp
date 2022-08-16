package com.servletsController;

import com.servlets.dao.DAOUser;
import com.servlets.model.UserAuth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePassword() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOUser dao = new DAOUser();

		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");

		UserAuth user = dao.getUser(id);
		boolean flag = dao.checkIsNewUser(id);
		user.setPassword(password);
		dao.updateUser(id, user);

		if (flag) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<h5 style='color: white; margin-left: 36%' Update Password Successfully</h5>");  
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
