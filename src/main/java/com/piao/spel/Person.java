package com.piao.spel;



public class Person {
    private String name;
    private int age;
    // city 引用address的属性
    private String city;
    private SuperCar superCar;
    // 根据car的price决定
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public SuperCar getSuperCar() {
        return superCar;
    }

    public void setSuperCar(SuperCar superCar) {
        this.superCar = superCar;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", superCar=" + superCar +
                ", info='" + info + '\'' +
                '}';
    }
}
