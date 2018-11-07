package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Course;
import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static Logger log = Logger.getLogger(CreateInstructorDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			log.info("Create new object");

			Instructor instructor = new Instructor("Micha³", "XXX", "xxx@wp.pl");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube/channel", "gameer");

			session.beginTransaction();
			instructor.setInstructorDetail(instructorDetail);
			log.info("Save object");
			session.save(instructor);
			session.getTransaction().commit();

			log.info("Done");
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
