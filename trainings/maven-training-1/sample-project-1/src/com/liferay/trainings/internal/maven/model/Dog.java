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

package com.liferay.trainings.internal.maven.model;

import java.io.Serializable;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Tibor Lipusz
 */
@Component
public class Dog implements InitializingBean, Serializable {

	public Dog() {
	}

	public Dog(String name) {
		_name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		_name = "Ray";
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private static final long serialVersionUID = -25148928676393299L;

	private String _name;

}