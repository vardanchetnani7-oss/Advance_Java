<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Login</title>
</head>
<body>
	<h2>Society Admin Login</h2>

	<% if (request.getAttribute("msg") != null) { %>
		<p style="color:red;"><%= request.getAttribute("msg") %></p>
	<% } %>

	<form action="admin" method="post">
		<input type="hidden" name="action" value="login">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

	<p>Not registered yet? <a href="admin-register.jsp">Register here</a></p>
</body>
</html>