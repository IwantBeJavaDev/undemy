package pl.undemy.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyLogToCloudAspect {
	private  Logger log = Logger.getLogger(getClass().getName());
	@Before("pl.undemy.spring.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAdvice() {
		log.info("\n =====>>>>> Executing @Before logToCloudAdvice");
	}
}
