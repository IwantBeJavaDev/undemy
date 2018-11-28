package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class MyDemoLoggingAspect {

	//declare pointcut for parameter from current package, and more parameter any type
	@Pointcut("execution (* pl.undemy.spring.dao.*.*(..))") 
	private void forDaoPackage() {};
	
	@Before("forDaoPackage()") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n =====>>>>> Executing @Before advice on method");

	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n =====>>>>> Executing @Before advice performApiAnalytics");
		
	}
}
