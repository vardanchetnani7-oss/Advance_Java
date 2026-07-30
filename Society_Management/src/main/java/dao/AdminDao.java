package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import DbConnection.DatabaseConnection;
import models.Admin;

public class AdminDao {

	public static void createAdmin(Admin a) {
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "insert into admin(fullname,email,password,phonenumber,societyname,registrationdate) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, a.getFullName());
			pst.setString(2, a.getEmail());
			pst.setString(3, a.getPassword());
			pst.setString(4, a.getPhoneNumber());
			pst.setString(5, a.getSocietyName());
			pst.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();
			System.out.println("admin registered successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from admin where email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static Admin checkLogin(Admin a) {
		Admin a1 = null;
		try {
			Connection conn = DatabaseConnection.createConnection();
			String sql = "select * from admin where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, a.getEmail());
			pst.setString(2, a.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				a1 = new Admin();
				a1.setAdminId(rs.getInt("adminid"));
				a1.setFullName(rs.getString("fullname"));
				a1.setEmail(rs.getString("email"));
				a1.setPassword(rs.getString("password"));
				a1.setPhoneNumber(rs.getString("phonenumber"));
				a1.setSocietyName(rs.getString("societyname"));
				a1.setRegistrationDate(rs.getTimestamp("registrationdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a1;
	}
}