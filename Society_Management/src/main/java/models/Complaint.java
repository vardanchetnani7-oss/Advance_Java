package models;

import java.sql.Timestamp;

public class Complaint {
	private int complaintid;
	private int memberid;
	private String subject;
	private String description;
	private String status;
	private Timestamp complaintDate;

	public Complaint() {
		super();
	}

	public Complaint(int complaintid, int memberid, String subject, String description, String status,
			Timestamp complaintDate) {
		super();
		this.complaintid = complaintid;
		this.memberid = memberid;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.complaintDate = complaintDate;
	}

	public int getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Timestamp complaintDate) {
		this.complaintDate = complaintDate;
	}

	@Override
	public String toString() {
		return "Complaint [complaintid=" + complaintid + ", memberid=" + memberid + ", subject=" + subject
				+ ", description=" + description + ", status=" + status + ", complaintDate=" + complaintDate + "]";
	}
}