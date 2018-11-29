package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyLogToCloudAspect {

	@Before("pl.undemy.spring.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAdvice() {
		System.out.println("\n =====>>>>> Executing @Before logToCloudAdvice");
	}
}
