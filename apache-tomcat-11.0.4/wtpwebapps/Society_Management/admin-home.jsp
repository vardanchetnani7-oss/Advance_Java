<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Member" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin Home</title>
</head>
<body>

	<h2>Welcome, <%= ((models.Admin) session.getAttribute("admin")).getFullName() %></h2>
	<h3>Pending Member Approvals</h3>

	<%
		List<Member> pendingList = (List<Member>) request.getAttribute("pendingList");
	%>

	<% if (pendingList == null || pendingList.isEmpty()) { %>
		<p>No pending member requests.</p>
	<% } else { %>
		<table border="1" cellpadding="8">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Flat No</th>
				<th>Registered On</th>
				<th>Action</th>
			</tr>
			<% for (Member m : pendingList) { %>
				<tr>
					<td><%= m.getFullName() %></td>
					<td><%= m.getEmail() %></td>
					<td><%= m.getPhoneNumber() %></td>
					<td><%= m.getFlatno() %></td>
					<td><%= m.getRegistrationDate() %></td>
					<td>
						<a href="admin?action=approve&memberid=<%= m.getMemberid() %>">Approve</a>
						&nbsp;|&nbsp;
						<a href="admin?action=reject&memberid=<%= m.getMemberid() %>">Reject</a>
					</td>
				</tr>
			<% } %>
		</table>
	<% } %>

</body>
</html>