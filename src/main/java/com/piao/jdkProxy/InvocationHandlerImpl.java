package com.piao.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler{
	
	private ElectricCar car ;
	
	InvocationHandlerImpl(ElectricCar car){
		this.car = car;
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		System.out.println("JDK proxy start...");
		method.invoke(car, args);
		System.out.println("JDK proxy end...");
		return null;
	}

}
