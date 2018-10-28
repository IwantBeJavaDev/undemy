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
			log.info("Update student wity email : zaneta@wp.pl");
			session.beginTransaction();
			session.createQuery("update Student set email='zaba@wp.pl' where email='zaneta@wp.pl'")
					.executeUpdate();
				
			log.info("Update student....");
			
			//start transaction
			session.getTransaction().commit();
			log.info("Done");
		} finally {
			session.close();
			factory.close();
		}
	}

}
