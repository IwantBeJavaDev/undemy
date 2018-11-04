package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;

public class DeleteBiIntructorDemo {
	
	public static Logger log = Logger.getLogger(DeleteBiIntructorDemo.class);
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
	
		
		try {
			log.info("get instructor detail");
			Long id = 3L;
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			log.info("instructor detail: " + instructorDetail); 
			
			log.info("Remove the associated object reference, break bi-directional link" ); 
			instructorDetail.setInstructor(null);
			
			log.info("Delete instructorDetail without instructor entity");
			session.delete(instructorDetail);
			
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
