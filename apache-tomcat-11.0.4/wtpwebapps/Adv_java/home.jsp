<%@page import="java.util.List"%>
<%@page import="dao.UserDao"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	%>
	<%
	User u = null;
	if (session.getAttribute("user") != null) {
		u = (User) session.getAttribute("user");
	}
	%>
	<%-- <%= %> expression tag--%>
	<h1 style="text-align: center;">
		Welcome :
		<%=u.getName()%>
	</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		List<User> list = UserDao.getAllUsers();
		%>
		<%
		for (User u1 : list) {
		%>
		<tr>
			<td><%=u1.getId()%></td>
			<td><%=u1.getName()%></td>
			<td><%=u1.getContact()%></td>
			<td><%=u1.getAddress()%></td>
			<td><%=u1.getEmail()%></td>
			<td><%=u1.getPassword()%></td>
			<td>
				<form action="userregister" method="post">
					<input type="hidden" name="id" value="<%=u1.getId()%>"> <input
						type="submit" name="action" value="edit">
				</form>
			</td>
			<%-- <td><a href="delete.jsp?id=<%=u1.getId()%>">Delete</a></td> --%>
			<td><a href="userregister?action=delete&id=<%=u1.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>

	<h1 style="text-align: center;">
		<a href="logout.jsp">Logout</a>
	</h1>
</body>
</html>