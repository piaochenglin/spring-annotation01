package com.piao.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {

    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("audi", new Car("audi", 33000));
        cars.put("bmw", new Car("bmw", 44000));
    }

    // 静态工厂方法
    public static Car getCar(String name) {
        return cars.get(name);
    }
}
