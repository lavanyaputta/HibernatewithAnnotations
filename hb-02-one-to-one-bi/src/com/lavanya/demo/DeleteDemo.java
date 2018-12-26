package com.lavanya.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Instructor;
import com.lavanya.demo.entity.InstructorDetail;

public class DeleteDemo {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			//start the transaction
			 session.beginTransaction();
			 int id=2;
			 
			 Instructor tempInstructor=session.get(Instructor.class,id);
			 System.out.println("Found Instructor :" +tempInstructor);
			 
			 if(tempInstructor != null) {
				 System.out.println("Deleting :"+tempInstructor);
				 
				 session.delete(tempInstructor);
			 }
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
			 
		} finally {
			factory.close();

		}
	}
}
