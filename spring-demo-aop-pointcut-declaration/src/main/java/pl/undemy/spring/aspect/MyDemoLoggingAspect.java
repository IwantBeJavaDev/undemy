package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	@Pointcut("execution (* pl.undemy.spring.dao.*.*(..))")

	@Before("execution (* pl.undemy.spring.dao.*.*(pl.undemy.spring.main.Account, ..))") //declare pointcut for parameter from current package, and more parameter any type
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>>>> Executing @Before advice on method");

	}
}
