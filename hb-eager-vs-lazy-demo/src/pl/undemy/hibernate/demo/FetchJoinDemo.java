package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import pl.undemy.hibernate.demo.entity.Course;
import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static Logger log = Logger.getLogger(FetchJoinDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			Long idInstructor = 4L;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
														+ "join fetch i.courses "
														+ "where i.idInstructor=:idInstructor",
									Instructor.class);
			query.setParameter("idInstructor", idInstructor);
			
			Instructor instructor = query.getSingleResult();
			
			log.info("luv2: " + instructor);
			session.getTransaction().commit();
			session.close();
			log.info("Session closed");
			log.info("luv2: " + instructor.getCourses());
			
			log.info("Done");
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
