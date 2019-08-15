package com.piao.xmlAop;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

// 切面的优先级，值越小优先级越高
public class CalculatorLog {

    public void methodBegins(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+" method begins with "+Arrays.asList(args));
    }

    public void methodEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" method end ... ");
    }

    public void methodReturning(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+" method return with " + result);
    }

    public void methodThrowing(JoinPoint joinPoint,Exception e){
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
