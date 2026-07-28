package spring.core.springcore;

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
    	ApplicationContext con = new ClassPathXmlApplicationContext("spring/core/springcore/core.xml");

		User u1 = (User) con.getBean("u1");
		System.out.println(u1);

		
    }
}
