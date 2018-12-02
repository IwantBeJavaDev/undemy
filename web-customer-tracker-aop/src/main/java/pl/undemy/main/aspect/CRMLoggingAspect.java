package pl.undemy.main.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger log = Logger.getLogger(getClass().getName()); 
	//setup pointcut
	@Pointcut("execution ( * pl.undemy.main.cotroller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution ( * pl.undemy.main.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution (* pl.undemy.main.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {}
	//add @Befor advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.info("=====> @Before method called: " + name);
	}
	
	//ad @AfterReturnig advice
}
