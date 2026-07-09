package com.hibernate.HibernateProj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
       User1 u1 = new User1(1,"java",1234567,"hyd","java@mail.com","java123");
       SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       
       session.save(u1);
       
       tx.commit();
       session.close();
       sf.close();
       
    }
}
