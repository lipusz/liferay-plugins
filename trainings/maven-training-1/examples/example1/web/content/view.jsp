<%--
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
--%>
<%@ page
	import="com.liferay.trainings.internal.maven.model.*"
	pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8" %>

<%
User user = (User)request.getAttribute("user");

if (user == null) {
	user = new User(-1, "Something went wrong. User could not be read from the request.");

	user.setDog(new Dog("Oops."));
}

Dog dog = user.getDog();
%>

<html lang="en">
	<head>
		<title>User bean view page</title>
		<meta charset="UTF-8" />
	</head>
	<body>
		User's age: <input id="userAge" value="<%= user.getAge() %>" />
		User's name: <input id="userName" value="<%= user.getName() %>" />
		User's dog's name: <input id="dogName" value="<%= dog.getName() %>" />

		<hr>
	</body>
</html>