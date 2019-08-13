package com.piao.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;



public class Main {
	public static void main(String[] args) {
		ElectricCar car = new ElectricCar();
		ClassLoader classLoader = car.getClass().getClassLoader();
		Class[] interfaces = car.getClass().getInterfaces();
		InvocationHandler handler = new InvocationHandlerImpl(car);
		
		Object o =Proxy.newProxyInstance(classLoader, interfaces,handler);
		Vehical v = (Vehical)o;
		v.drive();
		
		Rechargable r = (Rechargable)o;
		r.recharge();
	}

}
