package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyApiAnalyticsAspect {

	@Before("pl.undemy.spring.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void performAoiAnalyticsAdvice() {
		System.out.println("\n =====>>>>> Executing @Before performAoiAnalyticsAdvice");
	}
}
