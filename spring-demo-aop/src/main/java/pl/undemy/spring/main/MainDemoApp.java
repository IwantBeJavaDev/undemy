package pl.undemy.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.undemy.spring.dao.AccountDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDao accountDao = context.getBean(AccountDao.class);
		
		//call the business method
		accountDao.addAccount();
		accountDao.addAccount();
		accountDao.addAccount();
		accountDao.addAccount();
		//Close context
		
		context.close();
	}

}
