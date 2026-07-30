package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DatabaseConnection;
import models.Member;

public class MemberDao {
public static void createMember(Member m) {
	
	try {
		Connection conn = DatabaseConnection.createConnection();
		String sql ="insert into member(fullName,email,password,phoneNumber,flatno,status,registrationDate)values(?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,m.getFullName());
		pst.setString(2, m.getEmail());
		pst.setString(3, m.getPassword());
		pst.setString(4, m.getPhoneNumber());
		pst.setString(5, m.getFlatno());
		pst.setString(6, "PENDING");
		pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
		pst.executeUpdate();
		System.out.println("data insert or member registered successfully");
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public static boolean checkEmail(String email) {
	boolean flag = false;
	
	try {
		Connection conn = DatabaseConnection.createConnection();
		String sql = "select * from  member where email = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			flag = true;
			
		}	
}
	catch(Exception e) {
		e.printStackTrace();
	}
	return flag;
}
public static Member checkLogin(Member m) {
	Member m1 = null;
	try {
		Connection conn = DatabaseConnection.createConnection();
		String sql = "select * from member where email=? and password=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, m.getEmail());
		pst.setString(2, m.getPassword());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			m1 = new Member();
			m1.setMemberid(rs.getInt("memberid"));
			m1.setFullName(rs.getString("fullName"));
			m1.setEmail(rs.getString("email"));
			m1.setPassword(rs.getString("password"));
			m1.setPhoneNumber(rs.getString("phoneNumber"));
			m1.setFlatno(rs.getString("flatno"));
			m1.setStatus(rs.getString("status"));
			m1.setRegistrationDate(rs.getTimestamp("registrationDate"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return m1;
}
public static List<Member> getPendingMembers() {
	List<Member> list = new ArrayList<>();
	try {
		Connection conn = DatabaseConnection.createConnection();
		String sql = "select * from member where status=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, "PENDING");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println("Found pending member: " + rs.getString("email"));
			Member m = new Member();
			m.setMemberid(rs.getInt("memberid"));
			m.setFullName(rs.getString("fullname"));
			m.setEmail(rs.getString("email"));
			m.setPassword(rs.getString("password"));
			m.setPhoneNumber(rs.getString("phonenumber"));
			m.setFlatno(rs.getString("flatno"));
			m.setStatus(rs.getString("status"));
			m.setRegistrationDate(rs.getTimestamp("registrationdate"));
			list.add(m);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public static List<Member> getAllMembers() {
	List<Member> list = new ArrayList<>();
	try {
		Connection conn = DatabaseConnection.createConnection();
		String sql = "select * from member";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Member m = new Member();
			m.setMemberid(rs.getInt("memberid"));
			m.setFullName(rs.getString("fullname"));
			m.setEmail(rs.getString("email"));
			m.setPassword(rs.getString("password"));
			m.setPhoneNumber(rs.getString("phonenumber"));
			m.setFlatno(rs.getString("flatno"));
			m.setStatus(rs.getString("status"));
			m.setRegistrationDate(rs.getTimestamp("registrationdate"));
			list.add(m);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public static void approveMember(int memberid) {
	try {
		Connection conn = DatabaseConnection.createConnection();
		String sql = "update member set status=? where memberid=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, "APPROVED");
		pst.setInt(2, memberid);
		pst.executeUpdate();
		System.out.println("member approved successfully");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void rejectMember(int memberid) {
	try {
		Connection conn = DatabaseConnection.createConnection();
		String sql = "delete from member where memberid=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, memberid);
		pst.executeUpdate();
		System.out.println("member rejected and deleted successfully");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
