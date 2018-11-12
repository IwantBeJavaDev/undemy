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

public class CreateCoursesForMaryDemo {

	public static Logger log = Logger.getLogger(CreateCoursesForMaryDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Long idMaryStudent = 14L;
			session.beginTransaction();

			Student studentMary = session.get(Student.class, idMaryStudent);
			log.info("Load student: " + studentMary);
			log.info("Load student: " + studentMary.getCourses());
			log.info("Create courses");
			Course course1 = new Course("Rubik's Cube - How to Speed Cube");
			Course course2 = new Course("Atari 2600 - Game Development");
			
			course1.addStudent(studentMary);
			course2.addStudent(studentMary);
			
			log.info("Save course1: " + session.save(course1));
			log.info("Save course1: " + session.save(course2));
			
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
