package com.xzy.web01.aop;


import com.xzy.web01.entity.OperateLog;
import com.xzy.web01.mapper.OperateLogMapper;
import com.xzy.web01.util.CurrentHolder;
import com.xzy.web01.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class LogProxy {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.xzy.web01.annotation.Log)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable{
        Long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        Long end = System.currentTimeMillis();
        Long cost = end - start;
        OperateLog operateLog = new OperateLog();

        // 解析JWT令牌，获取当前操作员工号

        // 获取声明信息
        Map<String, Object> claims = CurrentHolder.getTokenClaimsHolder();

        operateLog.setOperateEmpId((Integer) claims.get("id"));

        // 从切入点读取操作信息
        operateLog.setClassName(pjp.getSignature().getDeclaringTypeName());
        operateLog.setMethodName(pjp.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
        operateLog.setReturnValue(result!=null ? result.toString() : "void");
        operateLog.setCostTime(cost);
        operateLog.setOperateTime(LocalDateTime.now());
        operateLogMapper.insert(operateLog);
        log.info("方法执行完毕：记录操作日志：{}", operateLog);
        return result;
    }
}
