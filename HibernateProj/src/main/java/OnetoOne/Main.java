package OnetoOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main {
public static void main(String[] args) {
	SessionFactory sf = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
	
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	Student s1 = new Student();
	s1.setSid(5);
	s1.setName("user1");
	s1.setContact(1234567);
	
	Student s2 = new Student();
	s2.setSid(6);
	s2.setName("user2");
	s2.setContact(6789045);
	
	Course c1 = new Course();
	c1.setCid(7);
	c1.setCname("java");
	c1.setCduration("6 months");

	Course c2 = new Course();
	c2.setCid(8);
	c2.setCname("python");
	c2.setCduration("5 months");
	
	s1.setCourse(c2);
	s2.setCourse(c1);
	
	c1.setStudent(s2);
	c2.setStudent(s1);
	
	session.save(s1);
	session.save(s2);
	session.save(c1);
	session.save(c2);
	
	tx.commit();
	session.close();
	sf.close();
}
}
