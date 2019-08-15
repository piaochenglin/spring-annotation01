package com.piao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    private ArithmeticCalculator target;

    MyInvocationHandler(ArithmeticCalculator target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 没有参数的方法，会报空指针异常，要加判断
        if (args != null){
            System.out.println(method.getName()+" method start with "+ Arrays.asList(args));
        } else {
            System.out.println(method.getName()+" method start with ");
        }
        Object result = null;
        try{
            System.out.println("前置通知");
            result = method.invoke(target,args);
            System.out.println("返回通知");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("异常通知");
        }
        System.out.println("后置通知");
        System.out.println(method.getName()+" method end ... ");
        // 有返回值的方法必须写返回值，要是返回null就会报空指针异常
        return result;
    }
}
