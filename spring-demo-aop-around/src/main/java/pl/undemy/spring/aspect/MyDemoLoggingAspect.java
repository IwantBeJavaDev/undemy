package pl.undemy.spring.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import pl.undemy.spring.main.Account;

@Aspect
@Order(3)
@Component
public class MyDemoLoggingAspect {
	
	@Around("execution(* pl.undemy.spring.service.*.getFortune(..))")
	public Object aroundGetFortuneAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====> @Around method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		System.out.println("\n===> Duration: " + duration/1000. + " seconds");
		return result;
	}
	
	@After("execution(* pl.undemy.spring.dao.AccountDao.findAccounts(..))")
	public void afterFinallyAccountAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====> @After method: " + method);
	}
	
	
	@AfterThrowing(
			pointcut="execution(* pl.undemy.spring.dao.AccountDao.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
		//print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====> @AfterThrowing method: " + method);
		//log the exception
		System.out.println("\n=====> the exception is: " + theExc);
	}
	
	
	
	//add a new advice for @AfterReturning on findAccounts method
	@AfterReturning(
			pointcut="execution(* pl.undemy.spring.dao.AccountDao.findAccounts(..))",
			returning ="result"
			)
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		//print out which method we are advising on
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====> @AfterReturning method: " + method);
		//print out the results of the method call
		System.out.println("\n=====> result is " + result);
		
		//let's post-process the data ... let's modify it
		convertAccountNameToUpperCase(result);
		System.out.println("\n=====> modify result is " + result);
	}
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		for (Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
		
	}

	//Using joinpoint to get access to method signature
	@Before("pl.undemy.spring.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		System.out.println("\n =====>>>>> Executing @Before beforeAddAccountAdvice");
		//display the method signature
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();

		System.out.println("Method: " + methodSignature);
		
		//dispaly method arguments
		
		Object[] args = joinPoint.getArgs();
		
		for (Object item : args) {
			System.out.println(item);
			
			if (item instanceof Account) {
				// downcast and print account specific stuff
				Account account = (Account)item;
				System.err.println("account name : " + account.getName());
				System.err.println("account level : " + account.getLevel());
			}
		}
	}
	

}