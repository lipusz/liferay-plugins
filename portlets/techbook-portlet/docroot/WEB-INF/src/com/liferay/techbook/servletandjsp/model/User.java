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

package com.liferay.techbook.servletandjsp.model;

/**
 * @author Tibor Lipusz
 */
public class User {

	public User(String email, String firstName) {
		_email = email;
		_firstName = firstName;
	}

	public String getEmail() {
		return _email;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setEmail(String email) {
		this._email = email;
	}

	public void setFirstName(String firstName) {
		this._firstName = firstName;
	}

	private String _email;
	private String _firstName;

}