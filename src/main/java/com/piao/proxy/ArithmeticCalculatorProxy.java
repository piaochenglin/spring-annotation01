package com.piao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ArithmeticCalculatorProxy {

    private ArithmeticCalculator target;

    ArithmeticCalculatorProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getProxy(){
        InvocationHandler handler = new MyInvocationHandler(target);
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        ClassLoader loader = target.getClass().getClassLoader();
        Object o = Proxy.newProxyInstance(loader,interfaces , handler);
        return (ArithmeticCalculator)o;

    }
}
