package com.piao.spel;

public class SuperCar {

    private String brand;
    private int price;
    private  double tyreParameter;


    public double getTyreParameter() {
        return tyreParameter;
    }

    public void setTyreParameter(double tyreParameter) {
        this.tyreParameter = tyreParameter;
    }

    public SuperCar() {
        System.out.println("SuperCar Constructor ...");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SuperCar{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyreParameter=" + tyreParameter +
                '}';
    }
}
