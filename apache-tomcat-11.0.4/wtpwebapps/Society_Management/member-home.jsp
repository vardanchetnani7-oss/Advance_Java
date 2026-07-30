<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Complaint" %>
<!DOCTYPE html>
<html>
<head>
<title>Member Home</title>
<style>
	.reminder {
		padding: 12px;
		margin-bottom: 20px;
		border-radius: 5px;
		font-weight: bold;
	}
	.upcoming {
		background-color: #fff3cd;
		color: #856404;
		border: 1px solid #ffeeba;
	}
	.overdue {
		background-color: #f8d7da;
		color: #721c24;
		border: 1px solid #f5c6cb;
	}
</style>
</head>
<body>

<%
	Member member = (Member) session.getAttribute("member");
	if (member == null) {
		response.sendRedirect("member-login.jsp");
		return;
	}
%>

	<h2>Welcome, <%= member.getFullName() %></h2>

	<%
		String maintenanceMsg = (String) request.getAttribute("maintenanceMsg");
		Boolean overdue = (Boolean) request.getAttribute("overdue");
		if (maintenanceMsg != null) {
	%>
		<div class="reminder <%= (overdue != null && overdue) ? "overdue" : "upcoming" %>">
			<%= maintenanceMsg %>
		</div>
	<% } %>

	<p>Flat No: <%= member.getFlatno() %></p>
	<p>Email: <%= member.getEmail() %></p>

<hr>
<h3>Raise a Complaint</h3>
<form action="member" method="post">
	<input type="hidden" name="action" value="submitComplaint">
	<table>
		<tr>
			<td>Subject:</td>
			<td><input type="text" name="subject" required></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><textarea name="description" rows="4" cols="30" required></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit Complaint"></td>
		</tr>
	</table>
</form>

<h3>Your Complaint History</h3>
<%
	List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints");
%>
<% if (complaints == null || complaints.isEmpty()) { %>
	<p>No complaints raised yet.</p>
<% } else { %>
	<table border="1" cellpadding="8">
		<tr>
			<th>Subject</th>
			<th>Description</th>
			<th>Status</th>
			<th>Date</th>
		</tr>
		<% for (Complaint c : complaints) { %>
			<tr>
				<td><%= c.getSubject() %></td>
				<td><%= c.getDescription() %></td>
				<td><%= c.getStatus() %></td>
				<td><%= c.getComplaintDate() %></td>
			</tr>
		<% } %>
	</table>
<% } %>

</body>
</html>