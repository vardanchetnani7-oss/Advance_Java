package OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course2 {

@Id
private int cid;
private String cname;
private String cduration;
@ManyToOne
private Student2 student;

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
public Student2 getStudent() {
	return student;
}
public void setStudent(Student2 student) {
	this.student = student;
}
public Course2(int cid, String cname, String cduration, Student2 student) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.cduration = cduration;
	this.student = student;
}
public Course2() {
	super();
	// TODO Auto-generated constructor stub
}


}
