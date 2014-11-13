/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.techbook.servletsandjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.techbook.servletandjsp.model.User;

/**
 * @author Tibor Lipusz
 */
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		request.setAttribute("serialVersionUID", serialVersionUID);

		HttpSession session = request.getSession();

		if (session != null) {
			User user = (User)session.getAttribute("user");

			if (user != null) {
				_userCount++;

				request.setAttribute("user", user);

				session.removeAttribute("user");
			}
		}

		request.setAttribute("userCount", _userCount);

		ServletContext servletContext = getServletContext();

		RequestDispatcher dispatcher = servletContext.getRequestDispatcher(
			"/view.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");

		if ((email != null) && (firstName != null)) {
			User user = new User(email, firstName);

			HttpSession session = request.getSession(true);

			session.setAttribute("user", user);
		}

		response.sendRedirect("view");
	}

	protected void doForward(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		ServletContext servletContext = getServletContext();

		RequestDispatcher dispatcher = servletContext.getRequestDispatcher(
			"/view.jsp");

		dispatcher.forward(request, response);
	}

	private static final long serialVersionUID = -8922584214068366001L;

	private int _userCount = 0;

}