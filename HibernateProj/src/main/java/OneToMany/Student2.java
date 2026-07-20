package OneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student2 {

	@Id
	private int id;
	private String name;
	private long contact;
	@OneToMany
	private List<Course2>courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Course2> getCourses() {
		return courses;
	}

	public void setCourses(List<Course2> courses) {
		this.courses = courses;
	}

	public Student2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student2(int id, String name, long contact, List<Course2> courses) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.courses = courses;
	}
	
}
