package com.example.productservice.aspect.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Log4j2
public class repositoriesLogging {

    @Pointcut("execution(public * com.example.productservice.repository.*.*(..))")
    public void repositoryPackage(){}

    @Before("repositoryPackage()")
    public void aspectBeforeMethods(JoinPoint joinPoint) {
        log.info("**************** REPOSITORY LAYER CALL *****************");
        log.info(joinPoint.getSignature().getDeclaringTypeName() + " class called");
        log.info(joinPoint.getSignature().getName() + " method called");
        log.info("parameters list: " + Arrays.stream(joinPoint.getArgs()).toList());
    }

    @AfterThrowing(pointcut = "repositoryPackage()", throwing = "ex")
    public void aspectAfterThrow(JoinPoint joinPoint, Exception ex) {
        log.info("**************** REPOSITORY LAYER THROWING *****************");
        log.info("throw exception from method: " + joinPoint.getSignature().getDeclaringTypeName());
        log.error(ex.getMessage());
    }
}
