package com.venkat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.demo.entity.Course;
import com.venkat.hibernate.demo.entity.Instructor;
import com.venkat.hibernate.demo.entity.InstructorDetail;
import com.venkat.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create a Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		//create a session
		Session session= factory.getCurrentSession();
		
		 try {
			 
			 
			Instructor tempInstructor = new Instructor("susan", "patel", "susan@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://susan.com/youtube", "gaming");
			// associate the objects together
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			 
			 //start the transaction
			 session.beginTransaction();
			 //note:this will also save the details object
			 //because of cascadeType.ALL
			 //
			 System.out.println("saving instructor:"+tempInstructor);
			 session.save(tempInstructor);
			 
			  
			 
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
			
		} finally {
			session.close();
			factory.close();
			
		}
	}

}
