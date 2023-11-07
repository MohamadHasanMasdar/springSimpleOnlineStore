package com.example.productservice.aspect.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j2
public class ControllersLogging {

    @Pointcut("execution(public * com.example.productservice.controller.*.*(..))")
    public void controllerPackage(){}


    @Before("controllerPackage()")
    public void aspectBeforeMethods(JoinPoint joinPoint) {
        log.info("**************** CONTROLLER LAYER CALL *****************");
        log.info(joinPoint.getSignature().getDeclaringTypeName() + " class called");
        log.info(joinPoint.getSignature().getName() + " method called");
        log.info("parameters list: " + Arrays.stream(joinPoint.getArgs()).toList());
    }

    @AfterReturning(pointcut = "controllerPackage()", returning = "returnString")
    public void aspectAfterReturn(Object returnString) {
        log.info("**************** CONTROLLER LAYER EXIT *****************");
        if (returnString != null)
            log.info("return value: " + returnString.toString());
    }

    @AfterThrowing(pointcut = "controllerPackage()", throwing = "ex")
    public void aspectAfterThrow(JoinPoint joinPoint, Exception ex) {
        log.info("**************** CONTROLLER LAYER THROWING *****************");
        log.info("throw exception from method: " + joinPoint.getSignature().getDeclaringTypeName());
        log.error(ex.getMessage());
    }
}
