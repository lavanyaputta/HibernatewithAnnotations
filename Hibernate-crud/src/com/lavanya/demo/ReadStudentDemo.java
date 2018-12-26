package com.lavanya.demo;

 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create a Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create a session
		Session session= factory.getCurrentSession();
		
		 try {
			 //use the session object to save the java object
			 System.out.println("creating a new student object");
			 
			 //create the student object
			 Student tempStudent=new Student("Daffy","duck","daffy@gmail.com");
			 
			 //start the transaction
			 session.beginTransaction();
			 
			 //save the student object
			 System.out.println("saving the student.......");
			 System.out.println(tempStudent);
			 session.save(tempStudent);
			 
			 
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 //my new code
			 
			//find the student id:Primary key
			 System.out.println("Saved student.Generated id: "+tempStudent.getId());
			 
			 //now get a new session and start transaction
			 
			 session=factory.getCurrentSession();
			 session.beginTransaction();
			 
			 //Retrieve the student based on the id:primary key
			 System.out.println("\nGetting student with id :"+tempStudent.getId());
			 
			 Student myStudent=session.get(Student.class, tempStudent.getId());
			 System.out.println("Get complete:"+ myStudent);
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
			
		} finally {
			factory.close();
			
		}
	}

}
