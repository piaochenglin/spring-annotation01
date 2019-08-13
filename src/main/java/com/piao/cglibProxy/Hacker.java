package com.piao.cglibProxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

// 实现了方法拦截器接口
public class Hacker implements MethodInterceptor{

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("method start");
		proxy.invokeSuper(object, args);
		System.out.println("method end");
		return null;
	}

}
