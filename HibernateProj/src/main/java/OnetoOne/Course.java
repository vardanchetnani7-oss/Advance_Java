package OnetoOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Course {
	@Id
private int cid;
private String cname;
private String cduration;

@OneToOne(mappedBy ="course")
private Student student;

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public String getCduration() {
	return cduration;
}

public void setCduration(String cduration) {
	this.cduration = cduration;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

@Override
public String toString() {
	return "Course [cid=" + cid + ", cname=" + cname + ", cduration=" + cduration + ", student=" + student + "]";
}

public Course(int cid, String cname, String cduration, Student student) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.cduration = cduration;
	this.student = student;
}

public Course() {
	super();
	// TODO Auto-generated constructor stub
}



}
