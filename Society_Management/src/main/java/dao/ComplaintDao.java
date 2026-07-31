package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DatabaseConnection;
import models.Complaint;

public class ComplaintDao {

	public static void createComplaint(Complaint c) {
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "insert into complaint(memberid,subject,description,status,complaintdate) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getMemberid());
			pst.setString(2, c.getSubject());
			pst.setString(3, c.getDescription());
			pst.setString(4, "PENDING");
			pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();
			System.out.println("complaint submitted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Complaint> getComplaintsByMember(int memberid) {
		List<Complaint> list = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from complaint where memberid=? order by complaintdate desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, memberid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Complaint c = new Complaint();
				c.setComplaintid(rs.getInt("complaintid"));
				c.setMemberid(rs.getInt("memberid"));
				c.setSubject(rs.getString("subject"));
				c.setDescription(rs.getString("description"));
				c.setStatus(rs.getString("status"));
				c.setComplaintDate(rs.getTimestamp("complaintdate"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static List<Complaint> getPendingComplaints() {
		List<Complaint> list = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from complaint where status=? order by complaintdate asc";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "PENDING");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Complaint c = new Complaint();
				c.setComplaintid(rs.getInt("complaintid"));
				c.setMemberid(rs.getInt("memberid"));
				c.setSubject(rs.getString("subject"));
				c.setDescription(rs.getString("description"));
				c.setStatus(rs.getString("status"));
				c.setComplaintDate(rs.getTimestamp("complaintdate"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Complaint> getAllComplaints() {
		List<Complaint> list = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from complaint order by complaintdate desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Complaint c = new Complaint();
				c.setComplaintid(rs.getInt("complaintid"));
				c.setMemberid(rs.getInt("memberid"));
				c.setSubject(rs.getString("subject"));
				c.setDescription(rs.getString("description"));
				c.setStatus(rs.getString("status"));
				c.setComplaintDate(rs.getTimestamp("complaintdate"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void resolveComplaint(int complaintid) {
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "update complaint set status=? where complaintid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "RESOLVED");
			pst.setInt(2, complaintid);
			pst.executeUpdate();
			System.out.println("complaint resolved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}