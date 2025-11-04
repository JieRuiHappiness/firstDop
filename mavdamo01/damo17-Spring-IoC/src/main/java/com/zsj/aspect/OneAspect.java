package com.zsj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class OneAspect {
@Before(value = "printqqq()")
    public void beforPrint(JoinPoint joinPoint){
    String name = joinPoint.getSignature().getName();
    System.out.println("name = " + name);
    int modifiers = joinPoint.getSignature().getModifiers();
    System.out.println("modifiers = " + modifiers);
    String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
    System.out.println("declaringTypeName = " + declaringTypeName);
    Object[] args = joinPoint.getArgs();
    System.out.println("args = " + Arrays.asList(args));

    System.out.println("**前置通知**");
    }
    @AfterReturning(value = "printqqq()",returning = "returns")
    public void afterPrint(Object returns){
        System.out.println("返回值为 = " + returns);
        System.out.println("**返回通知**");

    }
    @AfterThrowing(value ="printqqq()",throwing = "obj")
    public void afterExciption(Throwable obj){
        System.out.println("异常是 = " + obj);
        System.out.println("**异常通知**");

    }@After("printqqq()")
    public void finallyPrint(){
        System.out.println("**结束通知**");
    }
    @Pointcut("execution(public int *.*(int,int))")
    public void printAll(){
    }
    @Pointcut("@annotation(com.zsj.annotation.dop)")
    public void printqqq(){

    }

}
