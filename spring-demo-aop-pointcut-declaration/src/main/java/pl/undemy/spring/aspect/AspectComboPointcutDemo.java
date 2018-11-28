package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectComboPointcutDemo {

	@Pointcut("execution(* pl.undemy.spring.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("execution(* pl.undemy.spring.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* pl.undemy.spring.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter() ) ")
	public void forDaoPackageNoGetterAndSetter() {};
	
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =====>>>>> Executing @Before advice on method");
	}
}
