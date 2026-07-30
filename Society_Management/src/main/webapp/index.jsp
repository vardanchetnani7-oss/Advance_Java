<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Society Management System</title>
<style>
	body {
		font-family: Arial, sans-serif;
		text-align: center;
		margin-top: 100px;
	}
	h1 {
		margin-bottom: 40px;
	}
	.option-box {
		display: inline-block;
		width: 250px;
		padding: 30px;
		margin: 20px;
		border: 1px solid #ccc;
		border-radius: 8px;
		box-shadow: 2px 2px 8px rgba(0,0,0,0.1);
	}
	.option-box a {
		display: inline-block;
		margin-top: 15px;
		padding: 10px 20px;
		text-decoration: none;
		background-color: #4CAF50;
		color: white;
		border-radius: 5px;
	}
	.option-box a:hover {
		background-color: #45a049;
	}
</style>
</head>
<body>
	<h1>Welcome to Society Management System</h1>

	<div class="option-box">
		<h2>Member</h2>
		<p>Register as a society member</p>
		<a href="member-register.jsp">Member Register</a>
		<br>
		<a href="member-login.jsp">Member Login</a>
	</div>

	<div class="option-box">
		<h2>Admin</h2>
		<p>Register as a society admin</p>
		<a href="admin-register.jsp">Admin Register</a>
		<br>
		<a href="admin-login.jsp">Admin Login</a>
	</div>

</body>
</html>