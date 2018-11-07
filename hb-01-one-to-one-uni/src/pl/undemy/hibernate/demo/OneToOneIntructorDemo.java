package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;

public class OneToOneIntructorDemo {
	
	public static Logger log = Logger.getLogger(OneToOneIntructorDemo.class);
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
	
		
		try {
			log.info("Set data to instructor object");
			/*Instructor instructor = new Instructor("Micha³", "xxxx", "xxx@wp.pl");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://youtube/channel", "crossfit");*/
			Instructor instructor = new Instructor("Madhu", "xxxx", "xxx@wp.pl");
			InstructorDetail instructorDetail = new InstructorDetail("http://youtube/channel", "guitar");
			
			
			instructor.setInstructorDetail(instructorDetail);
			log.info("Saving data....");
			session.beginTransaction();
			//Note: this will also save the details object because of CascadeType.ALL
			session.save(instructor);
			session.getTransaction().commit();
			
			log.info("Done");
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
