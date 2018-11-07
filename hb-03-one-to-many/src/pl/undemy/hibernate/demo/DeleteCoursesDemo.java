package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Course;
import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static Logger log = Logger.getLogger(DeleteCoursesDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			
			Course hibernateCourse = new Course("Hibernate course");
			Course guitarCourse = new Course("Guitar");
			
			session.beginTransaction();
			Long idInstructor = 4L;
			Instructor instructor = session.get(Instructor.class, idInstructor);
			log.info("Get insturtor: " + instructor);
			hibernateCourse.setInstructor(instructor);
			guitarCourse.setInstructor(instructor);
			
			log.info("Add courses: " + instructor.getCourses());
			
			log.info("Save object");
			session.save(hibernateCourse);
			session.save(guitarCourse);
			
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
