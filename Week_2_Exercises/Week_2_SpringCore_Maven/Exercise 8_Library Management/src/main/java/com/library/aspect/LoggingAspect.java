package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Advice to run before any method execution in the service package
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore() {
        System.out.println("LoggingAspect.logBefore() : Method execution start");
    }

    // Advice to run after any method execution in the service package
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter() {
        System.out.println("LoggingAspect.logAfter() : Method execution end");
    }
}
