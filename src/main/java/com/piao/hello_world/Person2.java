package com.piao.hello_world;

import java.util.List;

public class Person2 {
    private String name;
    private int age;
    private List<SuperCar> cars;

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

    public List<SuperCar> getCars() {
        return cars;
    }

    public void setCars(List<SuperCar> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
