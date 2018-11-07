package pl.undemy.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Instructor;
import pl.undemy.hibernate.demo.entity.InstructorDetail;

public class DeleteIntructorDemo {

	public static Logger log = Logger.getLogger(DeleteIntructorDemo.class);

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			Long idInstructor = 1L;

			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, idInstructor);
			log.info("Found instructor : " + instructor);

			if (instructor != null) {
				// Note: will also delete associated "details" object
				session.delete(instructor);
				log.info("Delete instructor");
			}

			session.getTransaction().commit();

			log.info("Done");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
