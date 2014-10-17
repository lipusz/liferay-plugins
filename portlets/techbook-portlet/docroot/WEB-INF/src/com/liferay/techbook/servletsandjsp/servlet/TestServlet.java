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
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tibor Lipusz
 */
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		ServletContext servletContext = getServletContext();

		out.println("Success!");
		out.println(
			"ServletContext init param: " +
			servletContext.getInitParameter("techbook-param-1"));
		out.println(
			"ServletContext attribute: " +
			servletContext.getAttribute("techbook-attribute"));

		ServletConfig servletConfig = getServletConfig();

		out.println(
			"TestServlet init param: " +
			servletConfig.getInitParameter("servlet-init-param-1"));
	}

	private static final long serialVersionUID = -8922584214068366001L;

}