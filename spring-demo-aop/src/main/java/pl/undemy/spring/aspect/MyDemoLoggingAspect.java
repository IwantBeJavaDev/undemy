package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
//	@Before("execution (public void addAccount())") //declare pointcut for any method name addAccount
//	@Before("execution (public void pl.undemy.spring.dao.AccountDao.addAccount())") //declare pointcut for any method name addAccount only specific class
//	@Before("execution (public void add*())") //declare pointcut for any method name stat add I using wildcards
	@Before("execution (* add*())") //declare pointcut for any method name stat add I using wildcards. Modifier doesn't matter
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>>>> Executing @Before advice on method");

	}
}
