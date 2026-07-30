<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Member Registration</title>
</head>
<body>
	<h2>Society Member Registration</h2>

	<% if (request.getAttribute("msg") != null) { %>
		<p style="color:red;"><%= request.getAttribute("msg") %></p>
	<% } %>

	<form action="member" method="post">
		<input type="hidden" name="action" value="register">
		<table>
			<tr>
				<td>Full Name:</td>
				<td><input type="text" name="fullName" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><input type="text" name="phoneNumber" required></td>
			</tr>
			<tr>
				<td>Flat No:</td>
				<td><input type="text" name="flatno" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>

	<p>Already registered? <a href="member-login.jsp">Login here</a></p>
</body>
</html>