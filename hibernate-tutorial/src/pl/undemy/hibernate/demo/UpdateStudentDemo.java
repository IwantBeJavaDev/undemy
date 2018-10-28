package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	final static Logger log = Logger.getLogger(UpdateStudentDemo.class);
	public static void main(String[] args) {
		// create session factory
		
		SessionFactory  factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			Long studentId = 8L;
			//use the session object to save Java object
			log.info("Get student with id:" + studentId);
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
		
			log.info("Update student....");
			
			student.setFirstName("Boss");
			//start transaction
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
