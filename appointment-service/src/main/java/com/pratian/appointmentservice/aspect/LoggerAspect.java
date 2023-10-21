package com.pratian.appointmentservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MemberSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Aspect
@Component
public class LoggerAspect {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    //@Pointcut("within()")

//    @Before("execution(* com.patientService..*(..))")
//    public void beforeLogging()
//    {
//    	log.info("Before Logging");
//    }
//     
//    @After("execution(* com.patientService..*(..)))")
//    public void afterLogger()
//    {
//    	log.info("After Logging");
//    }
    
    
    

    @Around("execution(* com.pratian.appointmentservice..*(..))")
      public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
      {
        MemberSignature methodSignature =  (MemberSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        log.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
      }

    
}