package pl.undemy.spring.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.undemy.spring.dao.AccountDao;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
			
				AccountDao accountDao = context.getBean(AccountDao.class);
				List<Account> findAccounts = null;
				try {
					boolean tripWire = false;
					findAccounts = accountDao.findAccounts(tripWire);
					
				} catch (Exception e) {
					System.out.println("\n\nMain program... caugth exception " + e);
				}
				
				System.out.println("\n\nMain program afterFinally");
				System.out.println("-------");
				System.out.println(findAccounts);
				
				//Close context
				
				context.close();
	}

}
