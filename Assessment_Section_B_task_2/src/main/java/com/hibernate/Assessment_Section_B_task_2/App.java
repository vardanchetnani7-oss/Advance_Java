package com.hibernate.Assessment_Section_B_task_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Resturant restaurant = new Resturant("Taco Fiesta", "Austin", 4.5);

        MenuItem item1 = new MenuItem("Beef Tacos", 8.99, true);
        MenuItem item2 = new MenuItem("Chicken Quesadilla", 7.49, true);
        MenuItem item3 = new MenuItem("Veggie Burrito", 6.99, false);

        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item2);
        restaurant.addMenuItem(item3);

        session.save(restaurant);
        
        tx.commit();
        System.out.println("Restaurant and menu items persisted successfully.\n");
        session.close();
        sf.close();
    }
}
