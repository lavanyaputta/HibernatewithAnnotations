package com.lavanya.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Student;

public class CreateStudentDemo {

	 
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create the student object
			Student tempStudent = new Student("Lavanya", "Putta", "puttalavanya@gmail.com");
 			
			
		// start the trasaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the student object...........");

			session.save(tempStudent);

			// commit the transaction.
			session.getTransaction().commit();

			System.out.println("done!...........");

		} finally {
			factory.close();

		}
	}
}
