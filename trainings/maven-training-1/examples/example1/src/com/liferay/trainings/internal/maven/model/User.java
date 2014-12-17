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

/**
 * @author Tibor Lipusz
 */
public class User implements Serializable {

	public User() {
	}

	public User(int age, String name) {
		_age = age;
		_name = name;
	}

	public int getAge() {
		return _age;
	}

	public String getName() {
		return _name;
	}

	public void setAge(int age) {
		_age = age;
	}

	public void setName(String name) {
		_name = name;
	}

	private static final long serialVersionUID = 5363735489701386206L;

	private int _age;
	private String _name;

}