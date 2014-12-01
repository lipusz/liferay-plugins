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

package com.liferay.trainings.internal.maven.servlet.listener;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Tibor Lipusz
 */
public class TestServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		doLoadProperties(servletContextEvent);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

	protected void doLoadProperties(ServletContextEvent servletContextEvent) {

		// Load properties without EasyConf

		Properties properties = new Properties();

		ServletContext servletContext = servletContextEvent.getServletContext();

		try {
			properties.load(
				servletContext.getResourceAsStream(
					"/WEB-INF/classes/example.properties"));
		}
		catch (IOException ioException) {
			properties.setProperty("key", "Maven Training");
		}

		servletContext.setAttribute("property", properties.getProperty("key"));
	}

}