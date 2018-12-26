package com.venkat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.demo.entity.Instructor;
import com.venkat.hibernate.demo.entity.InstructorDetail;
import com.venkat.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create a Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//create a session
		Session session= factory.getCurrentSession();
		
		 try {
			 
			 
			 
			 
			 //start the transaction
			 session.beginTransaction();
			 int id=1;
			 
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
