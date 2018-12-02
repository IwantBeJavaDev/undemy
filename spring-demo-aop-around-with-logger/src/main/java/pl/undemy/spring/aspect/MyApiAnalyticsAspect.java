package pl.undemy.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyApiAnalyticsAspect {
	private  Logger log = Logger.getLogger(getClass().getName());
	@Before("pl.undemy.spring.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void performAoiAnalyticsAdvice() {
		log.info("\n =====>>>>> Executing @Before performAoiAnalyticsAdvice");
	}
}
