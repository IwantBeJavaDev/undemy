package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;

public class OneToOneBiIntructorDemo {
	
	public static Logger log = Logger.getLogger(OneToOneBiIntructorDemo.class);
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
	
		
		try {
			log.info("get instructor detail");
			Long id = 21L;
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			log.info("instructor detail: " + instructorDetail); 
			log.info("instructor : " + instructorDetail.getInstructor()); 
			session.getTransaction().commit();
			
			log.info("Done");
		}catch(Exception e) {
			e.getMessage();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
