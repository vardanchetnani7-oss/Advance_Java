package models;

import java.sql.Timestamp;

public class Admin {
	
	

private int adminId;
private String fullName;
private String email;
private String password;
private String phoneNumber;
private String SocietyName;
private Timestamp registrationDate;




public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(int adminId, String fullName, String email, String password, String phoneNumber, String societyName,
		Timestamp registrationDate) {
	super();
	this.adminId = adminId;
	this.fullName = fullName;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
	SocietyName = societyName;
	this.registrationDate = registrationDate;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getSocietyName() {
	return SocietyName;
}
public void setSocietyName(String societyName) {
	SocietyName = societyName;
}
public Timestamp getRegistrationDate() {
	return registrationDate;
}
public void setRegistrationDate(Timestamp registrationDate) {
	this.registrationDate = registrationDate;
}


@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", fullName=" + fullName + ", email=" + email + ", password=" + password
			+ ", phoneNumber=" + phoneNumber + ", SocietyName=" + SocietyName + ", registrationDate=" + registrationDate
			+ "]";
}


}
