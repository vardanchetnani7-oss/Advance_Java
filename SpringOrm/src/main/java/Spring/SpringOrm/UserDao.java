package Spring.SpringOrm;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {
private HibernateTemplate hibernateTemplate;


public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
}

@Transactional
public void createUser(User1 u) {
	this.hibernateTemplate.save(u);
}


public User1 getUserById(int id) {
	
	return this.hibernateTemplate.get(User1.class, id);
	
}
@Transactional
public void updateUser(User1 u) {
	this.hibernateTemplate.update(u);
}
@Transactional
public void deleteUser(int id) {
	User1 u = this.hibernateTemplate.get(User1.class, id);
	this.hibernateTemplate.delete(u);
}
}
