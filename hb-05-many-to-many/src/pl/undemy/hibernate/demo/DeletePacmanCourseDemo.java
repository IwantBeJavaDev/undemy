package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Course;
import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;
import pl.undemy.hibernate.demo.entity.Review;
import pl.undemy.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

	public static Logger log = Logger.getLogger(DeletePacmanCourseDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Long idPacmanCourse = 10L;
			session.beginTransaction();
			Course course = session.get(Course.class, idPacmanCourse);
			
			log.info("Delete course: " );
			session.delete(course);
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
