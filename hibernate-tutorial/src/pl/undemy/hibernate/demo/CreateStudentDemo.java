package pl.undemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory  factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			
			//use the session object to save Java object
			System.out.println("Create the studnet object");
			Student student = new Student("Micha³", "Baraniak", "michal@wp.pl");
			
			//start transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Save the student");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.err.println("Done");
			
		} finally {
			session.close();
		}
	}

}
