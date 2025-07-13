package com.xzy.web01.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RecordTimeCost {

    /*
    * 切入点路径匹配说明：
    *   execution(返回值类型 包名.类名.方法名(参数列表))
    *      第1个 * 表示返回值类型，* 表示任意返回值
    *      com.xzy.web01.service.impl是一个包名
    *      第2个 * 表示类名，* 表示任意类名
    *      第3个 * 匹配方法名，* 匹配任意方法名
    *      (..) 表示任意参数列表
    * */
//    @Around("execution(* com.xzy.web01.service.impl.*.*(..))")
    public Object recordTimeCost(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();
        Object res = pjp.proceed();
        long end = System.currentTimeMillis();
        double seconds = (end - start) / 1000.0;
        log.info("method {} time cost: {} s", pjp.getSignature(), String.format("%.3f", seconds));
        return res;
    }
}
