package com.lavanya.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Student;

public class DeleteStudentDemo {

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
			 
			 //delete the Student
			// System.out.println("deleting the student....");
			// session.delete(myStudent);
			 
			 //delete student id=2 
			 session.createQuery("delete from Student where id=2").executeUpdate();
			  
			 //commit the transaction
			 session.getTransaction().commit();
			 System.out.println("Done!");
			 
			
		} finally {
			factory.close();
			
		}
	}

}
