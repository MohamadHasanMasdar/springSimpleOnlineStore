package com.example.productservice.aspect.logging;

import com.example.productservice.exception.NotFoundExceptionHandler;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Log4j2
public class ServicesLogging {

    @Pointcut("execution(public * com.example.productservice.service.*.*(..))")
    public void servicePackage(){}

    @Before("servicePackage()")
    public void aspectBeforeMethods(JoinPoint joinPoint) {
        log.info("**************** SERVICE LAYER CALL *****************");
        log.info(joinPoint.getSignature().getDeclaringTypeName() + " class called");
        log.info(joinPoint.getSignature().getName() + " method called");
        log.info("parameters list: " + Arrays.stream(joinPoint.getArgs()).toList());
    }

    @AfterReturning(pointcut = "servicePackage()", returning = "returnString")
    public void aspectAfterReturn(Object returnString) {
        log.info("**************** SERVICE LAYER EXIT *****************");
        if (returnString != null)
            log.info("return value: " + returnString.toString());
    }

    @AfterThrowing(pointcut = "servicePackage()", throwing = "ex")
    public void aspectAfterThrow(JoinPoint joinPoint, Exception ex) {
        log.info("**************** SERVICE LAYER THROWING *****************");
        log.info("throw exception from method: " + joinPoint.getSignature().getDeclaringTypeName());
        log.error(ex.getMessage());
    }
}
