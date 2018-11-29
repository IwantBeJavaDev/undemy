package pl.undemy.spring.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.undemy.spring.dao.AccountDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDao accountDao = context.getBean(AccountDao.class);

		List<Account> findAccounts = accountDao.findAccounts();
		
		System.out.println("\n\nMain program afterReturning");
		System.out.println("-------");
		System.out.println(findAccounts);
		
		//Close context
		
		context.close();
	}

}
