package com.piao.hello_world;

public class Person {

    private String name;
    private int age;
    private SuperCar car;

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

    public SuperCar getCar() {
        return car;
    }

    public void setCar(SuperCar car) {
        this.car = car;
    }

    public Person(String name, int age, SuperCar car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
