package OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main2 {
public static void main(String[] args) {
	SessionFactory sf = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	Student2 s1 = new Student2();
	s1.setId(5);
	s1.setName("user1");
	s1.setContact(1234567);
	
	Course2 c1 = new Course2();
	c1.setCid(6);
	c1.setCname("java");
	c1.setCduration("6 months");
	
	Course2 c2 = new Course2();
	c2.setCid(7);
	c2.setCname("python");
	c2.setCduration("4 months");
	
	List<Course2>courseList = new ArrayList<Course2>();
	courseList.add(c1);
	courseList.add(c2);
	
	s1.setCourses(courseList);
	
	c1.setStudent(s1);
	c2.setStudent(s1);
	
	session.save(s1);
	session.save(c2);
	session.save(c1);
	
	tx.commit();
	session.close();
	sf.close();
}
}
