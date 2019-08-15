package com.piao.annotationAopLog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面的优先级，值越小优先级越高
@Order(1)
@Aspect
@Component
public class ValidationAspect {

    // 不同包要加全包名  com.piao.annotationAopLog.CalculatorLog.pointCut()
    @Before("CalculatorLog.pointCut()")
    public void validate(){
        System.out.println("===> validate aspect");
    }
}
