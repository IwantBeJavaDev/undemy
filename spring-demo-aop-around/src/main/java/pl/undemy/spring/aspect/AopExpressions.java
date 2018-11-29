package pl.undemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
//pointcut declarations
	
	@Pointcut("execution(* pl.undemy.spring.dao.*.*(..))")
	public void forDaoPackage() {};
	
	@Pointcut("execution(* pl.undemy.spring.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* pl.undemy.spring.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter() ) ")
	public void forDaoPackageNoGetterAndSetter() {};
}
