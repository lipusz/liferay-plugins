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

package com.liferay.trainings.internal.maven.servlet;

import com.liferay.trainings.internal.maven.model.Dog;
import com.liferay.trainings.internal.maven.model.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tibor Lipusz
 */
public class TestServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ClassPathXmlApplicationContext appContext = null;

		try {
			appContext = new ClassPathXmlApplicationContext("beans.xml");

			_user = (User)appContext.getBean(User.class);

			ServletContext servletContext = getServletContext();

			boolean overrideBeanDefaults = (Boolean)servletContext.getAttribute(
				"overrideBeanDefaults");

			if (overrideBeanDefaults) {
				_user.setAge((Integer)servletContext.getAttribute("userAge"));
				_user.setName((String)servletContext.getAttribute("userName"));
			}
		}
		catch (BeansException beansException) {
			_user = new User(-1, "Error loading user bean.");

			_user.setDog(new Dog("No user, no dog bean."));
		}
		finally {
			if (appContext != null) {
				appContext.close();
			}
		}
	}

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		request.setAttribute("user", _user);

		ServletContext servletContext = getServletContext();

		RequestDispatcher dispatcher = servletContext.getRequestDispatcher(
			"/content/view.jsp");

		dispatcher.forward(request, response);
	}

	private static final long serialVersionUID = -8922584214068366001L;

	private User _user;

}