package com.lavanya.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create a Session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// query the students
			List<Student> theStudents = session.createQuery("from Student").list();
			// display the students
			displayStudents(theStudents);

			
			// query the students lastname='kumar'
			theStudents = session.createQuery("\n\nfrom Student s where s.lastName='kumar'").list();
			System.out.println("students the last name is kumar...");
			displayStudents(theStudents);

			// query the studenst the last name is 'kumar' and first name is 'shashi'
			theStudents = session.createQuery("from Student s where s.lastName='kumar' OR s.lastName='pavan'").list();
			System.out.println("the studenst the last name is 'kumar' and first name is 'shashi'");
			displayStudents(theStudents);

			// query students where email LIKE %'gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			System.out.println("where email LIKE %'gmail.com'");
			
			
			displayStudents(theStudents);
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudents : theStudents) {
			System.out.println(tempStudents);
		}
	}

}
