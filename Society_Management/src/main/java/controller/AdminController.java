package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Admin;
import models.Complaint;
import models.Member;

import java.io.IOException;
import java.util.List;

import dao.AdminDao;
import dao.ComplaintDao;
import dao.MemberDao;
import models.FunctionBooking;
import dao.FunctionBookingDao;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		// TODO Auto-generated method stub
		if (action == null) {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("admin-login.jsp");
			return;
		}
		
		if (action.equalsIgnoreCase("home")) {
			List<Member> pendingList = MemberDao.getPendingMembers();
			List<Complaint> pendingComplaints = ComplaintDao.getPendingComplaints();
			List<FunctionBooking> pendingBookings = FunctionBookingDao.getPendingBookings();
			request.setAttribute("pendingBookings", pendingBookings);
			request.setAttribute("pendingList", pendingList);
			request.setAttribute("pendingComplaints", pendingComplaints);
			request.getRequestDispatcher("admin-home.jsp").forward(request, response);

		} else if (action.equalsIgnoreCase("approve")) {
			int memberid = Integer.parseInt(request.getParameter("memberid"));
			MemberDao.approveMember(memberid);
			response.sendRedirect("admin?action=home");

		} else if (action.equalsIgnoreCase("reject")) {
			int memberid = Integer.parseInt(request.getParameter("memberid"));
			MemberDao.rejectMember(memberid);
			response.sendRedirect("admin?action=home");

		} else if (action.equalsIgnoreCase("resolveComplaint")) {
			int complaintid = Integer.parseInt(request.getParameter("complaintid"));
			ComplaintDao.resolveComplaint(complaintid);
			response.sendRedirect("admin?action=home");
		}else if (action.equalsIgnoreCase("approveBooking")) {
			int bookingid = Integer.parseInt(request.getParameter("bookingid"));
			FunctionBookingDao.approveBooking(bookingid);
			response.sendRedirect("admin?action=home");

		} else if (action.equalsIgnoreCase("rejectBooking")) {
			int bookingid = Integer.parseInt(request.getParameter("bookingid"));
			FunctionBookingDao.rejectBooking(bookingid);
			response.sendRedirect("admin?action=home");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			Admin a = new Admin();
			a.setFullName(request.getParameter("fullName"));
			a.setEmail(request.getParameter("email"));
			a.setPassword(request.getParameter("password"));
			a.setPhoneNumber(request.getParameter("phoneNumber"));
			a.setSocietyName(request.getParameter("societyName"));

			String email = request.getParameter("email");
			boolean flag = AdminDao.checkEmail(email);
			if (flag == true) {
				request.setAttribute("msg", "account already registered");
				request.getRequestDispatcher("admin-register.jsp").forward(request, response);
			} else {
				AdminDao.createAdmin(a);
				response.sendRedirect("admin-login.jsp");
			}
		} else if (action.equalsIgnoreCase("login")) {
			Admin a = new Admin();
			a.setEmail(request.getParameter("email"));
			a.setPassword(request.getParameter("password"));
			boolean flag = AdminDao.checkEmail(request.getParameter("email"));
			if (flag == true) {
				Admin a1 = AdminDao.checkLogin(a);
				if (a1 == null) {
					request.setAttribute("msg", "password is incorrect");
					request.getRequestDispatcher("admin-login.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("admin", a1);
					response.sendRedirect("admin?action=home"); 
				}
			} else {
				request.setAttribute("msg", "account not registered");
				request.getRequestDispatcher("admin-login.jsp").forward(request, response);
			}
		}
	}

}