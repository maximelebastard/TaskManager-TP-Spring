package fr.istic.taa.taskmanager.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* fr.istic.taa.taskmanager.rest.*Resource.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[BEGIN] method : " + joinPoint.getSignature().getName());
    }

    @After("execution(* fr.istic.taa.taskmanager.rest.*Resource.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[FINISH] method : " + joinPoint.getSignature().getName());
    }
}
