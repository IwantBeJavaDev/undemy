package pl.undemy.spring.aspect;

import java.util.List;
import java.util.logging.Logger;

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
	private Logger log = Logger.getLogger(getClass().getName());

	@Around("execution(* pl.undemy.spring.service.*.getFortune(..))")
	public Object aroundGetFortuneAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		log.info("\n=====> @Around method: " + method);

		long begin = System.currentTimeMillis();

		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			log.warning("Major accident! But on worries, your private AOP helicopter is on the way");
			//rethrow the exception
			throw e;
		}
		
		long end = System.currentTimeMillis();

		long duration = end - begin;
		log.info("\n===> Duration: " + duration / 1000. + " seconds");
		return result;
	}

	@After("execution(* pl.undemy.spring.dao.AccountDao.findAccounts(..))")
	public void afterFinallyAccountAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		log.info("\n=====> @After method: " + method);
	}

	@AfterThrowing(pointcut = "execution(* pl.undemy.spring.dao.AccountDao.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		log.info("\n=====> @AfterThrowing method: " + method);
		// log the exception
		log.info("\n=====> the exception is: " + theExc);
	}

	// add a new advice for @AfterReturning on findAccounts method
	@AfterReturning(pointcut = "execution(* pl.undemy.spring.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		// print out which method we are advising on

		String method = joinPoint.getSignature().toShortString();
		log.info("\n=====> @AfterReturning method: " + method);
		// print out the results of the method call
		log.info("\n=====> result is " + result);

		// let's post-process the data ... let's modify it
		convertAccountNameToUpperCase(result);
		log.info("\n=====> modify result is " + result);
	}

	private void convertAccountNameToUpperCase(List<Account> result) {
		for (Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}

	}

	// Using joinpoint to get access to method signature
	@Before("pl.undemy.spring.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {

		log.info("\n =====>>>>> Executing @Before beforeAddAccountAdvice");
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		log.info("Method: " + methodSignature);

		// dispaly method arguments

		Object[] args = joinPoint.getArgs();

		for (Object item : args) {
			log.info(item.toString());

			if (item instanceof Account) {
				// downcast and print account specific stuff
				Account account = (Account) item;
				System.err.println("account name : " + account.getName());
				System.err.println("account level : " + account.getLevel());
			}
		}
	}

}