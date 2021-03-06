package com.lavanya.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lavanya.demo.entity.Instructor;
import com.lavanya.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			Instructor tempInstructor = new Instructor("pavan", "kumar", "pavan@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://pavan.com/youtube", "luv2code");

			// associate the objects together
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start the transaction
			session.beginTransaction();
			// note:this will also save the details object
			// because of cascadeType.ALL
			//
			System.out.println("saving instructor:" + tempInstructor);
			session.save(tempInstructor);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}
}
