package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DatabaseConnection;
import models.FunctionBooking;

public class FunctionBookingDao {

	public static void createBooking(FunctionBooking b) {
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "insert into functionbooking(memberid,functionname,functiondate,purpose,status,bookingdate) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, b.getMemberid());
			pst.setString(2, b.getFunctionName());
			pst.setDate(3, b.getFunctionDate());
			pst.setString(4, b.getPurpose());
			pst.setString(5, "PENDING");
			pst.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();
			System.out.println("function booking submitted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<FunctionBooking> getBookingsByMember(int memberid) {
		List<FunctionBooking> list = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from functionbooking where memberid=? order by bookingdate desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, memberid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				FunctionBooking b = new FunctionBooking();
				b.setBookingid(rs.getInt("bookingid"));
				b.setMemberid(rs.getInt("memberid"));
				b.setFunctionName(rs.getString("functionname"));
				b.setFunctionDate(rs.getDate("functiondate"));
				b.setPurpose(rs.getString("purpose"));
				b.setStatus(rs.getString("status"));
				b.setBookingDate(rs.getTimestamp("bookingdate"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<FunctionBooking> getPendingBookings() {
		List<FunctionBooking> list = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from functionbooking where status=? order by bookingdate asc";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "PENDING");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				FunctionBooking b = new FunctionBooking();
				b.setBookingid(rs.getInt("bookingid"));
				b.setMemberid(rs.getInt("memberid"));
				b.setFunctionName(rs.getString("functionname"));
				b.setFunctionDate(rs.getDate("functiondate"));
				b.setPurpose(rs.getString("purpose"));
				b.setStatus(rs.getString("status"));
				b.setBookingDate(rs.getTimestamp("bookingdate"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<FunctionBooking> getAllBookings() {
		List<FunctionBooking> list = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from functionbooking order by bookingdate desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				FunctionBooking b = new FunctionBooking();
				b.setBookingid(rs.getInt("bookingid"));
				b.setMemberid(rs.getInt("memberid"));
				b.setFunctionName(rs.getString("functionname"));
				b.setFunctionDate(rs.getDate("functiondate"));
				b.setPurpose(rs.getString("purpose"));
				b.setStatus(rs.getString("status"));
				b.setBookingDate(rs.getTimestamp("bookingdate"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void approveBooking(int bookingid) {
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "update functionbooking set status=? where bookingid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "APPROVED");
			pst.setInt(2, bookingid);
			pst.executeUpdate();
			System.out.println("booking approved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rejectBooking(int bookingid) {
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "update functionbooking set status=? where bookingid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "REJECTED");
			pst.setInt(2, bookingid);
			pst.executeUpdate();
			System.out.println("booking rejected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}