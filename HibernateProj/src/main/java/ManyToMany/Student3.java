package ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student3 {

	@Id
	private int sid;
	private String name;
	private long contact;
	@ManyToMany
	private List<Course3>courses;
	
	
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
	public List<Course3> getCourses() {
		return courses;
	}
	public void setCourses(List<Course3> courses) {
		this.courses = courses;
	}
	public Student3(int sid, String name, long contact, List<Course3> courses) {
		super();
		this.sid = sid;
		this.name = name;
		this.contact = contact;
		this.courses = courses;
	}
	public Student3() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student3 [sid=" + sid + ", name=" + name + ", contact=" + contact + ", courses=" + courses + "]";
	}
	
	
	
}
