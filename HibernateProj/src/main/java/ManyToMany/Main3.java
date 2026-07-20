package ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main3 {
public static void main(String[] args) {
	SessionFactory sf = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	Student3 s1 = new Student3();
	s1.setSid(1);
	s1.setName("abc");
	s1.setContact(98765321);
	
	
	Student3 s2 = new Student3();
	s2.setSid(2);
	s2.setName("cde");
	s2.setContact(123456);
	
	Course3 c1 = new Course3();
	c1.setCid(1);
	c1.setCname("java");
	c1.setCduration("6 months");
	
	
	Course3 c2 = new Course3();
	c2.setCid(2);
	c2.setCname("python");
	c2.setCduration("4 months");
	
	List<Course3>courselist = new ArrayList<>();
	courselist.add(c1);
	courselist.add(c2);
	
	List<Student3>studentlist = new ArrayList<>();
	studentlist.add(s1);
	studentlist.add(s2);
	
	s1.setCourses(courselist);
	s2.setCourses(courselist);

	c1.setStudent(studentlist);
	c2.setStudent(studentlist);

	session.save(s1);
	session.save(s2);
	session.save(c1);
	session.save(c2);

	tx.commit();
	session.close();
	sf.close();

	
	
}
}

