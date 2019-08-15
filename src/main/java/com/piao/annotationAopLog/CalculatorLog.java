package com.piao.annotationAopLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
// 切面的优先级，值越小优先级越高
@Order(2)
@Aspect
@Component
public class CalculatorLog {

    @Pointcut("execution(* com.piao.annotationAopLog.ArithmeticCalculatorImpl.*(..))")
    public void pointCut(){}

    // 前置通知
    @Before("pointCut()")
    public void methodBegins(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+" method begins with "+Arrays.asList(args));
    }

    // 后置通知
    // 发生异常也会执行，但是取不到返回值，在返回通知里才能取到返回值
    @After("pointCut()")
    public void methodEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" method end ... ");
    }

    // 返回通知 可以返回 返回值的
    @AfterReturning(value = "pointCut()",returning = "result")
    public void methodReturning(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+" method return with " + result);
    }

    // 出现的异常，和catch的异常不一致，就catch不住了
    // 异常通知
    @AfterThrowing(value = "execution(* com.piao.annotationAopLog.ArithmeticCalculatorImpl.*(..))",throwing = "e")
    public void methodReturning(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName()+" method occur " + e);
    }

//    @Around("execution(* com.piao.annotationAopLog.ArithmeticCalculatorImpl.*(..))")
//    public Object methodAround(ProceedingJoinPoint pjp){
//        Object result = null;
//        String name = pjp.getSignature().getName();
//        Object[] args = pjp.getArgs();
//        try {
//            System.out.println(name+" 环绕 前置 "+Arrays.asList(args));
//            result = pjp.proceed();
//            System.out.println(name+" 环绕 返回 "+result);
//        } catch (Throwable throwable) {
//            System.out.println(name+" 环绕 异常 "+throwable);
////            throwable.printStackTrace();
//            throw new RuntimeException(throwable);
//        }
//        System.out.println(name+" 环绕 后置 ");
//        return result;
//    }
}
