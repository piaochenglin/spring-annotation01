package com.piao.hello_world;

public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("hello," + name);
    }

    public HelloWorld(String name) {
        System.out.println("constructor," + name);
    }

    public HelloWorld() {
    }
}
