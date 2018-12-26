package com.venkat.hibernate.demo;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.demo.entity.Course;
import com.venkat.hibernate.demo.entity.Instructor;
import com.venkat.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			 session.beginTransaction();
			 
			 int theId=1;
			 
			 Query query=session.createQuery("select i from Instructor i "
			 											+ "JOIN FETCH i.courses "
			 											+ "where i.id=:theInstructorId"
			 											,Instructor.class);
			 
			 query.setParameter("theInstructorId", theId);
			 
			 Instructor tempInstructor=(Instructor) query.getSingleResult();
			 
			 System.out.println("luv2code:Instructor:"+tempInstructor);
			 
			 
			 
			 //commit the transaction
			 session.getTransaction().commit();
			 session.close();
			 
			 System.out.println("courses:"+tempInstructor.getCourses());
			 
			 System.out.println("Done!");
			 
			
		} finally {
			session.close();
			factory.close();
			
		}
	}

}
