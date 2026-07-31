package models;

import java.sql.Date;
import java.sql.Timestamp;

public class FunctionBooking {
	private int bookingid;
	private int memberid;
	private String functionName;
	private Date functionDate;
	private String purpose;
	private String status;
	private Timestamp bookingDate;

	public FunctionBooking() {
		super();
	}

	public FunctionBooking(int bookingid, int memberid, String functionName, Date functionDate, String purpose,
			String status, Timestamp bookingDate) {
		super();
		this.bookingid = bookingid;
		this.memberid = memberid;
		this.functionName = functionName;
		this.functionDate = functionDate;
		this.purpose = purpose;
		this.status = status;
		this.bookingDate = bookingDate;
	}

	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public Date getFunctionDate() {
		return functionDate;
	}
	public void setFunctionDate(Date functionDate) {
		this.functionDate = functionDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "FunctionBooking [bookingid=" + bookingid + ", memberid=" + memberid + ", functionName="
				+ functionName + ", functionDate=" + functionDate + ", purpose=" + purpose + ", status=" + status
				+ ", bookingDate=" + bookingDate + "]";
	}
}