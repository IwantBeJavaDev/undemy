package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class AspectComboPointcutDemo {
	
	@Before("pl.undemy.spring.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =====>>>>> Executing @Before beforeAddAccountAdvice");
	}
	

}