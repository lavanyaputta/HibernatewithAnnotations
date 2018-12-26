package com.lavanya.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create a Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create a session
		Session session= factory.getCurrentSession();
		
		 try {
			  int studentId=1;
			 
			 //now get a new session and start transaction
			 
			 session=factory.getCurrentSession();
			 session.beginTransaction();
			 
			 //Retrieve the student based on the id:primary key
			 System.out.println("\nGetting student with id :"+studentId);
			 
			 Student myStudent=session.get(Student.class, studentId);
			 System.out.println("updating student.........");
			 myStudent.setFirstName("Scooby");
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 
			 
			 //new code
			 session=factory.getCurrentSession();
			 session.beginTransaction();
			 //update email for all students
			 System.out.println("update email for all students........");
			 
			 session.createQuery("update Student set email='foo@ymail.com'").executeUpdate();
			 
			 
			 //commit the transaction
			 session.getTransaction().commit();
			 System.out.println("Done!");
			 
			
		} finally {
			factory.close();
			
		}
	}

}
