package com.tek.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Component
public class Loggingadvice {

	Logger log = LoggerFactory.getLogger(Loggingadvice.class);

	@Pointcut(value = "execution(* com.tek.*.*.*(..))")
	public void myPointCut() {

	}

	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {

		ObjectMapper mapper = new ObjectMapper();

		String methodName = pjp.getSignature().getName();

		String className = pjp.getTarget().getClass().toString();
		
		StopWatch stopWatch =new StopWatch();
		

		Object[] args = pjp.getArgs();

		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(args));

		stopWatch.start();
		Object object = pjp.proceed();
		stopWatch.stop();

		log.info(className + " : " + methodName + "()" + "Response : " + mapper.writeValueAsString(object)+ "::::"+ stopWatch.getTotalTimeMillis()+ " ms");

		return object;

	}

}
