package com.piao.cycle;

public class Car {

    private String brand;

    public Car() {
        System.out.println("Car Constructor...");

    }

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public void init(){
        System.out.println("init ...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }

    public void destroy(){
        System.out.println("destroy ...");
    }
}
