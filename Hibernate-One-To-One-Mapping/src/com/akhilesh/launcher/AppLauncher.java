package com.akhilesh.launcher;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akhilesh.Utility.HibernateUtility;
import com.akhilesh.entity.Instructor;
import com.akhilesh.entity.InstructorDetail;

public class AppLauncher {
	
	private static SessionFactory sessionFactory  = HibernateUtility.getSessionFactory();
	private static Session session = HibernateUtility.getSession();

	
	public static void insertRecord() {

		try {
			System.out.println("Creating a new Instructor Object object");
			
			
			Instructor instructor1 = new Instructor("Akhilesh", "Gupta", "akhi@gmail.com");
			 InstructorDetail instructorDetail1 = new InstructorDetail("TechMind",
			 "Learning");
			 
			
			
			Instructor instructor = new Instructor("Amit1", "Gupta1", "amit@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("TechinalMind", "Learning");

			instructor.setInstructorDetail(instructorDetail);
			instructor1.setInstructorDetail(instructorDetail1);
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the Instrctor");
			session.save(instructor);
			session.save(instructor1);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			sessionFactory.close();
		}

	}
   
	public static void deleteRecord(int recordId) {
		
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, recordId);
		
		System.out.println("Instructor found "+instructor);
		
		if(instructor !=null) {
			System.out.println("Delete Instructor : "+instructor);
			session.delete(instructor);
		} 
	}
	
	public static void getDetails(Object object , int indexOfRecord) {
		Instructor instructor;
		InstructorDetail instructorDetail;
		try {
		session.beginTransaction();
		if(object instanceof Instructor) {
			instructor = session.get(Instructor.class, indexOfRecord);
			System.out.println("Instructor :: "+instructor);
			System.out.println("InstructorDetail ::"+instructor.getInstructorDetail());
		}
		else if(object instanceof InstructorDetail) {
			instructorDetail = session.get(InstructorDetail.class, indexOfRecord);
			System.out.println("InstructorDetail ::"+instructorDetail);
			System.out.println("Instructor ::"+instructorDetail.getInstructor());
		}
		session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//handle connection leak issue
			session.close();
			sessionFactory.close();
		}
	}
	
	public static List<Instructor> findAllInstructorsWithJpql() {
		session.beginTransaction();
	    return session.createQuery("SELECT a FROM Instructor a", Instructor.class).getResultList();      
	}
	
	public static void main(String[] args) {
		//insertRecord();
	  //deleteRecord(3);
		//getDetails(new InstructorDetail(), 1);
		getDetails(new Instructor(), 100);
	  //System.out.println(findAllInstructorsWithJpql());
	}

}
