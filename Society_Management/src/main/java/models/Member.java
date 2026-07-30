package models;

import java.sql.Timestamp;

public class Member {
private int memberid;
private String fullName;
private String email;
private String password;
private String phoneNumber;
private String flatno;
private String status;
private Timestamp registrationDate;
public Member() {
	super();
	// TODO Auto-generated constructor stub
}
public Member(int memberid, String fullName, String email, String password, String phoneNumber, String flatno,
		String status, Timestamp registrationDate) {
	super();
	this.memberid = memberid;
	this.fullName = fullName;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.flatno = flatno;
	this.status = status;
	this.registrationDate = registrationDate;
}
public int getMemberid() {
	return memberid;
}
public void setMemberid(int memberid) {
	this.memberid = memberid;
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
public String getFlatno() {
	return flatno;
}
public void setFlatno(String flatno) {
	this.flatno = flatno;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Timestamp getRegistrationDate() {
	return registrationDate;
}
public void setRegistrationDate(Timestamp registrationDate) {
	this.registrationDate = registrationDate;
}
@Override
public String toString() {
	return "Member [memberid=" + memberid + ", fullName=" + fullName + ", email=" + email + ", password=" + password
			+ ", phoneNumber=" + phoneNumber + ", flatno=" + flatno + ", status=" + status + ", registrationDate="
			+ registrationDate + "]";
}

}
