package com.truck.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truck.logic.impl.MemberDaoImpl;

public class LoginServlet extends HttpServlet {
	MemberDaoImpl daoImpl = null;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		daoImpl = new MemberDaoImpl();

		String username = request.getParameter("username") == null ? ""
				: request.getParameter("username");
		String password = request.getParameter("password") == null ? ""
				: request.getParameter("password");

		if (daoImpl.login(username, password)) {
			request.getSession().setAttribute("user", username);
			this.getServletContext().getRequestDispatcher("/admin/index.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("result", "请检查您输入的帐号或密码是否正确?");
			this.getServletContext().getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}

	}
}
