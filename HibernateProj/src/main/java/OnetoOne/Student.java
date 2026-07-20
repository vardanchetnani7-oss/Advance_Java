package OnetoOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
@Id
private int sid;
private String name;
private long contact;
@OneToOne
@JoinColumn(name = "cid")
private Course course;




public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", name=" + name + ", contact=" + contact + ", course=" + course + "]";
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int sid, String name, long contact, Course course) {
	super();
	this.sid = sid;
	this.name = name;
	this.contact = contact;
	this.course = course;
}




}
