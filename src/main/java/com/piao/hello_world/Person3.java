package com.piao.hello_world;

import java.util.Map;

public class Person3 {
    private String name;
    private int age;
    private Map<String,SuperCar> cars;

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

    public Map<String, SuperCar> getCars() {
        return cars;
    }

    public void setCars(Map<String, SuperCar> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
