package com.leonhead.chessplan.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.leonhead.chessplan.controller.*.*(..))")
	private void forControllerPackage() {}

	@Pointcut("execution(* com.leonhead.chessplan.service.*.*(..))")
	private void forServicePackage() {}

	@Pointcut("execution(* com.leonhead.chessplan.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forApplicationFlow() {}

	@Before("forApplicationFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("calling method: " + method);

		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			logger.info("argument: " + object);
		}
	}
	
	@AfterReturning(pointcut = "forApplicationFlow()",returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("calling method: " + method);
		
		logger.info("result: " + result);
	}

}
