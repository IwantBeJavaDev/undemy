package pl.undemy.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory  factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session

		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			//query student
			List<Student> studentList = session.createQuery("from Student").getResultList();
			displayStudents(studentList);
			
			studentList = session.createQuery("from Student s where s.firstName ='¯aneta'").getResultList();
			
			//display student
			displayStudents(studentList);
			
			session.getTransaction().commit();
			
			System.err.println("Done");
			
		} finally {
			session.close();
			
		}
	}

	private static void displayStudents(List<Student> studentList) {
		studentList.forEach( item -> System.out.println(item.toString()));
	}

}
