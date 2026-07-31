<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Complaint" %>
<%@ page import="models.FunctionBooking" %>
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



<hr>
<h3>Book a Function/Hall</h3>
<form action="member" method="post">
	<input type="hidden" name="action" value="bookFunction">
	<table>
		<tr>
			<td>Function Name:</td>
			<td><input type="text" name="functionName" required></td>
		</tr>
		<tr>
			<td>Function Date:</td>
			<td><input type="date" name="functionDate" required></td>
		</tr>
		<tr>
			<td>Purpose:</td>
			<td><textarea name="purpose" rows="3" cols="30"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit Booking Request"></td>
		</tr>
	</table>
</form>

<h3>Your Booking History</h3>
<%
	List<FunctionBooking> bookings = (List<FunctionBooking>) request.getAttribute("bookings");
%>
<% if (bookings == null || bookings.isEmpty()) { %>
	<p>No bookings made yet.</p>
<% } else { %>
	<table border="1" cellpadding="8">
		<tr>
			<th>Function Name</th>
			<th>Date</th>
			<th>Purpose</th>
			<th>Status</th>
		</tr>
		<% for (FunctionBooking b : bookings) { %>
			<tr>
				<td><%= b.getFunctionName() %></td>
				<td><%= b.getFunctionDate() %></td>
				<td><%= b.getPurpose() %></td>
				<td><%= b.getStatus() %></td>
			</tr>
		<% } %>
	</table>
<% } %>
</body>
</html>