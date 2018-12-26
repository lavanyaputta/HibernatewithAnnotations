package com.lavanya.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Course;
import com.lavanya.demo.entity.Instructor;
import com.lavanya.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			 
			 Instructor tempInstructor=session.get(Instructor.class,theId);
			 
			 Course tempCourse1=new Course("Air-Guitar -the ultimate Guide");
			 Course tempCourse2=new Course("the pinball master class");
					 
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
 			
			session.save(tempCourse1);
			session.save(tempCourse2);
			  
			 
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
			
		} finally {
			session.close();
			factory.close();
			
		}
	}

}
