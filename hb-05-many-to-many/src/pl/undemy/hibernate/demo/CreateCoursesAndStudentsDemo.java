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

public class CreateCoursesAndStudentsDemo {

	public static Logger log = Logger.getLogger(CreateCoursesAndStudentsDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			log.info("Create new object");
			Course course = new Course("Pacman - How To Score One Million Points");
			Student student1 = new Student("Jonh", "Done", "john@lov2code.com", DateUtil.parseDate("23.03.2009"));
			Student student2 = new Student("Mary", "Public", "mary@luv2code.com", DateUtil.parseDate("23.03.2009"));

			course.addStudent(student1);
			course.addStudent(student2);
			log.info("Save the course");
			session.save(student1);
			session.save(student2);
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
