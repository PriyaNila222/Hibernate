package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Insert {
	public static void main(String[] args) {
		System.out.println("Connecting to database");
		SessionFactory factory = null;
		Session session = null;
		
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		System.out.println("Created");
		
		Teacher t1 = new Teacher("aa","bb","a.gmail.com");
		Teacher t2 = new Teacher("fff","sdf","b.gmail.com");
		Teacher t3 = new Teacher("bdfb","dsfsd","c.gmail.com");
		Teacher t4 = new Teacher("hfgf","bad","d.gmail.com");
		
		Transaction tx = null;
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(t4);
			tx.commit();
		} 
		catch(Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
		}
	}

}
