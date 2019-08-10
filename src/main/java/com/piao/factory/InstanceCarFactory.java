package com.piao.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {

    private Map<String, Car> cars;

    InstanceCarFactory() {
        cars = new HashMap<>();
        cars.put("ford", new Car("ford", 550000));
        cars.put("das auto", new Car("das auto", 660000));
    }

    public Car getCar(String name) {
        return cars.get(name);
    }
}
