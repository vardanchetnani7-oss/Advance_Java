package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Complaint;
import models.Member;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import dao.ComplaintDao;
import dao.MemberDao;
import models.FunctionBooking;
import dao.FunctionBookingDao;
import java.sql.Date;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			return;
		}

		HttpSession session = request.getSession();
		if (session.getAttribute("member") == null) {
			response.sendRedirect("member-login.jsp");
			return;
		}

		if (action.equalsIgnoreCase("home")) {
			// Monthly maintenance reminder logic
			double maintenanceAmount = 2000.0;   // fixed amount, change as needed
			int dueDay = 5;                      // maintenance due by 5th of every month

			Calendar cal = Calendar.getInstance();
			int today = cal.get(Calendar.DAY_OF_MONTH);
			String monthName = new SimpleDateFormat("MMMM yyyy").format(cal.getTime());

			String maintenanceMsg;
			boolean overdue = false;

			if (today <= dueDay) {
				maintenanceMsg = "Maintenance of \u20b9" + maintenanceAmount + " for " + monthName + " is due by the " + dueDay + "th.";
			} else {
				maintenanceMsg = "Maintenance of \u20b9" + maintenanceAmount + " for " + monthName + " is OVERDUE (was due on the " + dueDay + "th).";
				overdue = true;
			}

			request.setAttribute("maintenanceMsg", maintenanceMsg);
			request.setAttribute("overdue", overdue);
			
			
			Member member = (Member) session.getAttribute("member");
			List<Complaint> complaints = ComplaintDao.getComplaintsByMember(member.getMemberid());
			request.setAttribute("complaints", complaints);
			List<FunctionBooking> bookings = FunctionBookingDao.getBookingsByMember(member.getMemberid());
			request.setAttribute("bookings", bookings);

			
			request.getRequestDispatcher("member-home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			Member m = new Member();
			m.setFullName(request.getParameter("fullName"));
			m.setEmail(request.getParameter("email"));
			m.setPassword(request.getParameter("password"));
			m.setPhoneNumber(request.getParameter("phoneNumber"));
			m.setFlatno(request.getParameter("flatno"));

			String email = request.getParameter("email");
			boolean flag = MemberDao.checkEmail(email);
			if (flag == true) {
				request.setAttribute("msg", "account already registered");
				request.getRequestDispatcher("member-register.jsp").forward(request, response);
			} else {
				MemberDao.createMember(m);
				response.sendRedirect("member-login.jsp");
			}
		} else if (action.equalsIgnoreCase("login")) {
			Member m = new Member();
			m.setEmail(request.getParameter("email"));
			m.setPassword(request.getParameter("password"));
			boolean flag = MemberDao.checkEmail(request.getParameter("email"));
			if (flag == true) {
				Member m1 = MemberDao.checkLogin(m);
				if (m1 == null) {
					request.setAttribute("msg", "password is incorrect");
					request.getRequestDispatcher("member-login.jsp").forward(request, response);
				} else {
					if (m1.getStatus().equalsIgnoreCase("PENDING")) {
						request.setAttribute("msg", "your account is pending admin approval");
						request.getRequestDispatcher("member-login.jsp").forward(request, response);
					} else {
						HttpSession session = request.getSession();
						session.setAttribute("member", m1);
						response.sendRedirect("member?action=home");
					}
				}
			} else {
				request.setAttribute("msg", "account not registered");
				request.getRequestDispatcher("member-login.jsp").forward(request, response);
			}
		}else if (action.equalsIgnoreCase("submitComplaint")) {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			if (member == null) {
				response.sendRedirect("member-login.jsp");
				return;
			}

			Complaint c = new Complaint();
			c.setMemberid(member.getMemberid());
			c.setSubject(request.getParameter("subject"));
			c.setDescription(request.getParameter("description"));

			ComplaintDao.createComplaint(c);
			response.sendRedirect("member?action=home");
		}
		else if (action.equalsIgnoreCase("bookFunction")) {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			if (member == null) {
				response.sendRedirect("member-login.jsp");
				return;
			}

			FunctionBooking b = new FunctionBooking();
			b.setMemberid(member.getMemberid());
			b.setFunctionName(request.getParameter("functionName"));
			b.setFunctionDate(Date.valueOf(request.getParameter("functionDate")));  // expects yyyy-MM-dd
			b.setPurpose(request.getParameter("purpose"));

			FunctionBookingDao.createBooking(b);
			response.sendRedirect("member?action=home");
		}
	}

}