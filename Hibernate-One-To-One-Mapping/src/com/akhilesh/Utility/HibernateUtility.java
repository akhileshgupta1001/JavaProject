package com.akhilesh.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;

public class HibernateUtility {

	public static SessionFactory getSessionFactory() {
		// Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		return sessionFactory;
	}

	public static Session getSession() {
		// create session
		Session session = getSessionFactory().getCurrentSession();
		return session;
	}

}
