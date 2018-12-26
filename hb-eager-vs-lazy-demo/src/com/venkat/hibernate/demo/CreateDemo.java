package com.venkat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.demo.entity.Instructor;
import com.venkat.hibernate.demo.entity.InstructorDetail;
import com.venkat.hibernate.demo.entity.Student;

public class CreateDemo {

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
			 //create the object and 
			/* Instructor tempInstructor=new Instructor("venkata","swamy","venkat@gmail.com");
			 
			 InstructorDetail tempInstructorDetail=new InstructorDetail("http://venkat.com/youtube","luv2code");
			 //associate the objects together
			 tempInstructor.setInstructorDetail(tempInstructorDetail);*/
			 
			Instructor tempInstructor = new Instructor("pavan", "kumar", "pavan@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://pavan.com/youtube", "luv2code");
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
			factory.close();
			
		}
	}

}
