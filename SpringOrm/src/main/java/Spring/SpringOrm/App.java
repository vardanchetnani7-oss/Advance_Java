package Spring.SpringOrm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext con = new ClassPathXmlApplicationContext("Spring/SpringOrm/SpringOrm.xml");

    		UserDao dao = (UserDao)con.getBean("dao");
    		User1 u1 =new User1(1,"java",12345678,"xyz");
    		dao.createUser(u1);
		
    }
}
