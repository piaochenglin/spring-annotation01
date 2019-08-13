package com.piao.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;

public class Main {
	public static void main(String[] args) {
		Programer p = new Programer();
		Hacker h = new Hacker();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(p.getClass());
		enhancer.setCallback(h);
		// 生成的类名Programer$$EnhancerByCGLIB$$c5e0ba51
		Programer proxy = (Programer) enhancer.create();
		
		proxy.say("1");
		proxy.doSomeThing("swim", 2);
	}

}
