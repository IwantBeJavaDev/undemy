package pl.undemy.spring.aspect;

import org.aspectj.lang.JoinPoint;
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