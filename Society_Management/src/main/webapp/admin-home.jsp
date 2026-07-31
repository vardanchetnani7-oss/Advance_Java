<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Member" %>
<%@ page import="models.Complaint" %>
<%@ page import="models.FunctionBooking" %>
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


<hr>
<h3>Pending Complaints</h3>

<%
	List<Complaint> pendingComplaints = (List<Complaint>) request.getAttribute("pendingComplaints");
%>

<% if (pendingComplaints == null || pendingComplaints.isEmpty()) { %>
	<p>No pending complaints.</p>
<% } else { %>
	<table border="1" cellpadding="8">
		<tr>
			<th>Member ID</th>
			<th>Subject</th>
			<th>Description</th>
			<th>Date</th>
			<th>Action</th>
		</tr>
		<% for (Complaint c : pendingComplaints) { %>
			<tr>
				<td><%= c.getMemberid() %></td>
				<td><%= c.getSubject() %></td>
				<td><%= c.getDescription() %></td>
				<td><%= c.getComplaintDate() %></td>
				<td>
					<a href="admin?action=resolveComplaint&complaintid=<%= c.getComplaintid() %>">Mark Resolved</a>
				</td>
			</tr>
		<% } %>
	</table>
<% } %>



<hr>
<h3>Pending Function Booking Requests</h3>
<%
	List<FunctionBooking> pendingBookings = (List<FunctionBooking>) request.getAttribute("pendingBookings");
%>
<% if (pendingBookings == null || pendingBookings.isEmpty()) { %>
	<p>No pending booking requests.</p>
<% } else { %>
	<table border="1" cellpadding="8">
		<tr>
			<th>Member ID</th>
			<th>Function Name</th>
			<th>Date</th>
			<th>Purpose</th>
			<th>Action</th>
		</tr>
		<% for (FunctionBooking b : pendingBookings) { %>
			<tr>
				<td><%= b.getMemberid() %></td>
				<td><%= b.getFunctionName() %></td>
				<td><%= b.getFunctionDate() %></td>
				<td><%= b.getPurpose() %></td>
				<td>
					<a href="admin?action=approveBooking&bookingid=<%= b.getBookingid() %>">Approve</a>
					&nbsp;|&nbsp;
					<a href="admin?action=rejectBooking&bookingid=<%= b.getBookingid() %>">Reject</a>
				</td>
			</tr>
		<% } %>
	</table>
<% } %>
</body>
</html>