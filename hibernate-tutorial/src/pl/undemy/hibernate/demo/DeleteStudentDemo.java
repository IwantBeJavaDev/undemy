package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	final static Logger log = Logger.getLogger(DeleteStudentDemo.class);
	public static void main(String[] args) {
		// create session factory
		
		SessionFactory  factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			log.info("Delete student with id=8");
			session.beginTransaction();
			
			Student student = session.get(Student.class, 8L);
			session.delete(student);
			
			//start transaction
			session.getTransaction().commit();
			log.info("Done");
		} finally {
			session.close();
			factory.close();
		}
	}

}
