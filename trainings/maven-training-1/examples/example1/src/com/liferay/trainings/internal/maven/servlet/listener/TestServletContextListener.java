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
		ServletContext servletContext = servletContextEvent.getServletContext();

		String propsValue = "Something went wrong loading...";

		// Load properties without EasyConf

//		java.util.Properties properties = new Properties();
//
//		try {
//			properties.load(
//				servletContext.getResourceAsStream(
//					"/WEB-INF/classes/example.properties"));
//
//			propsValue = properties.getProperty("key");
//		}
//		catch (java.io.IOException ioException) {
//			properties.setProperty("maven.example", propsValue);
//		}

		// Load properties with EasyConf

		com.germinus.easyconf.ComponentConfiguration conf =
			com.germinus.easyconf.EasyConf.getConfiguration("example");

		com.germinus.easyconf.ComponentProperties properties =
			conf.getProperties();

		propsValue = properties.getString("maven.example", propsValue);

		servletContext.setAttribute("property", propsValue);
	}

}