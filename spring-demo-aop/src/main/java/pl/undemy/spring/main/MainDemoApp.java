package pl.undemy.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.undemy.spring.dao.AccountDao;
import pl.undemy.spring.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDao accountDao = context.getBean(AccountDao.class);
		MembershipDao membershipDao = context.getBean(MembershipDao.class);
		//call the business method
		accountDao.addAccount();
		membershipDao.addAccount();
		//Close context
		
		context.close();
	}

}
