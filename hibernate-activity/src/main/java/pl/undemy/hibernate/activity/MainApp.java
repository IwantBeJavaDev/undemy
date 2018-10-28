package pl.undemy.hibernate.activity;

import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.undemy.hibernate.activity.entity.Employee;

public class MainApp {

	final static Logger log = Logger.getLogger(MainApp.class);
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
			
			log.info("Save object");
			session.beginTransaction();
			
			session.save(new Employee("Micha³", "xxxx", "Google"));
			session.save(new Employee("Tomasz", "yyyyy", "Apple"));
			session.save(new Employee("Micha³", "zzzzz", "Microsoft"));
			session.save(new Employee("Micha³", "uuuu", "Amazon"));
			
			session.getTransaction().commit();
			
			log.info("Retriving all data from employee");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Stream<Employee> employeeStream = session.createQuery("from Employee").getResultStream();
			
			employeeStream.forEach(item -> log.info(item.toString()));
			
			session.getTransaction().commit();

			log.info("Update employee name for id 1");
			
			Long employeeId = 7L;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, employeeId);
			
			employee.setFirstName("Kuba");
			
			session.getTransaction().commit();
			
			log.info("Delete employye by id 2");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			employeeId = 8L;
			employee = session.get(Employee.class, employeeId);
			session.delete(employee);
			session.getTransaction().commit();
			
			log.info("Done.");
			
			
		}finally {
			session.close();
			factory.close();
		}
		
		
	}

}
