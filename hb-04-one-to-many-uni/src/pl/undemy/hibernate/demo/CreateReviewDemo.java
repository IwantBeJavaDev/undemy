package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Course;
import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;
import pl.undemy.hibernate.demo.entity.Review;

public class CreateReviewDemo {

	public static Logger log = Logger.getLogger(CreateReviewDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			
			session.beginTransaction();
			log.info("Create new object");
			Course course = new Course("Pacman - How To Score One Million Points") ;
			course.add(new Review("Great course ... loved it!"));
			course.add(new Review("Cool course, job well done."));
			course.add(new Review("What a dumb course, you are an idiot"));
			
			
			log.info("Save the course");
			session.save(course);
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
