package com.xzy.web01.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogProxy {

    @Around("@annotation(com.xzy.web01.annotation.Log)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable{
        log.info("开始执行方法：{}",pjp.getSignature().getName());
        Object result = pjp.proceed();
        log.info("方法执行完毕：{}",pjp.getSignature().getName());
        return result;
    }
}
