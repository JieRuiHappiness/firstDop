package com.zsj.aspect;

import com.zsj.cache.MyCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ThereeAspect {

    @Pointcut("execution(* com.zsj.service.TigerService.*())")
    public void printAll(){
    }
    @Around("printAll()")
    public Object getDate(ProceedingJoinPoint joinPoint){
        try {
            String key="2025";
            String s = MyCache.get(key);
            if (s==null){
                s=  (String) joinPoint.proceed();
                System.out.println("[缓存]查询数据库成功");
            }else {
                System.out.println("[缓存没有查询数据库成功");
            }
           MyCache.set(key,s);
        return s;
        } catch (Throwable e) {
            System.out.println("异常信息为= " + e);

            throw new RuntimeException(e);
        } finally {
            System.out.println("[AOP 缓存] 释放数据库连接，方法名：" + joinPoint.getSignature().getName());
        }
    }
}
