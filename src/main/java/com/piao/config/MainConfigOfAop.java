package com.piao.config;

import com.piao.aop.LogAspect;
import com.piao.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/*
  AOP：动态代理
     指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式；

     1，在pom文件中导入aop模块（aspects）
     2，定义一个业务逻辑类（MathCalculator），在业务逻辑运行的时候将日志进行打印（方法前，方法后，返回，异常）
     3，定义一个日志切面类（LogAspect），切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行
        通知方法：
          前置通知(@Before)
          后置通知(@After) 无论方法正常结束，还是异常结束
          返回通知(@AfterReturning)
          异常通知(@AfterThrowing)
          环绕通知(@Around)
      4，给切面类的目标方法何时何地运行
      5，将切面类和业务逻辑类都加入到容器中
      6，必须告诉spring哪个类时切面类
      7，在配置类中加@EnableAspectJAutoProxy
          在spring 中有很多的EnableXXX
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
