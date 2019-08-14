package com.piao.annotationAopLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLog {

    // 前置通知
    @Before("execution(* com.piao.annotationAopLog.ArithmeticCalculatorImpl.*(..))")
    public void methodBegins(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+" method begins with "+Arrays.asList(args));
    }

    // 后置通知
    // 发生异常也会执行，但是取不到返回值，在返回通知里才能取到返回值
    @After("execution(* com.piao.annotationAopLog.ArithmeticCalculatorImpl.*(..))")
    public void methodEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" method end ... ");
    }
}
