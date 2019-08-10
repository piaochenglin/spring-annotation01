package com.piao.hello_world;

public class Person5 {
    private String name;
    private int age;
    private Address address;
    private SuperCar superCar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public SuperCar getSuperCar() {
        return superCar;
    }

    public void setSuperCar(SuperCar superCar) {
        this.superCar = superCar;
    }

    @Override
    public String toString() {
        return "Person5{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", superCar=" + superCar +
                '}';
    }
}
