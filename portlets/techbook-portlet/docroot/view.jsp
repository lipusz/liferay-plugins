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

<%@ include file="/init.jsp" %>

<%
int userCount = (Integer)request.getAttribute("userCount");

User user = (User)request.getAttribute("user");
%>
<html>
	<head>
		<title>Main Page</title>

		<script type="text/javascript">
			function sayHello() {

				<%
				if (user != null) {
				%>

					alert("Congrat! You've successfully submitted the form!");

				<%
				}
				%>

			}
		</script>
	</head>

	<body onload="sayHello()">
		<label for="serialVersionUID">SerialVersionUID of the servlet: </label>
		<input id="serialVersionUID" value='<%= request.getAttribute("serialVersionUID") %>'>

		<label for="count">UserCount: </label>
		<input id="count" value="<%= userCount %>">

		<hr>

		<form action="save" method="post">
			<label for="email">Email: </label>
			<input <%= (user == null) ? "" : DISABLED %> id="email" name="email" value='<%= (user == null) ? "" : user.getEmail() %>' />

			<label for="firstName">First Name: </label>
			<input <%= (user == null) ? "" : DISABLED %> id="firstName" name="firstName" value='<%= (user == null) ? "" : user.getFirstName() %>' />

			<input value="Submit" type="submit" />
		</form>

		<form action="view">
			<input value="Refresh" type="submit" />
		</form>
	</body>
</html>

<%!
final String DISABLED = "disabled=\"disabled\"";
%>