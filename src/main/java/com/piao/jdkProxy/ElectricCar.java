package com.piao.jdkProxy;

public class ElectricCar implements Vehical,Rechargable{

	@Override
	public void drive() {
		System.out.println("drive...");
		
	}

	@Override
	public void recharge() {
	System.out.println("recharge...");	
	}
}
