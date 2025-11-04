package com.zsj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(1)
public class TwoAspect {
    @Around("com.zsj.aspect.OneAspect.printqqq()")
    public Object printAll2(ProceedingJoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        try {
            System.out.println("###环绕通知  开启事务###形成列表= " + Arrays.asList(args));
            Object proceed = joinPoint.proceed(args);
            System.out.println("###环绕通知  提交事务###"+" 返回值为= " + proceed);
            return proceed;

        } catch (Throwable e) {
            System.out.println("###环绕通知  回滚事务###异常="+e.getClass().getName());
            throw new RuntimeException(e);

        } finally {
            System.out.println("[AOP 环绕通知] 释放数据库连接，方法名：" + name);     }

    }
}
