package com.piao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspect {

    // 抽取公共切入点表达式
    @Pointcut("execution ( public int com.piao.aop.MathCalculator.*(..) )")
    public void pointCut() {
    }

    // 切入点表达式
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行开始....参数列表是"+ Arrays.asList(args));
    }

    @After("execution(public int com.piao.aop.MathCalculator.*(..))")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+"运行结束....");
    }


    // joinPoint必须写在参数第一位，否则报异常
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result) {
        System.out.println(joinPoint.getSignature().getName()+"正常返回....运行结果:"+ result);
    }

    @AfterThrowing(value="pointCut()",throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("除法异常....异常信息:"+ exception);
    }
}
