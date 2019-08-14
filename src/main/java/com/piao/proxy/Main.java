package com.piao.proxy;

public class Main {

    public static void main(String[] args) {

        ArithmeticCalculatorProxy proxy = new ArithmeticCalculatorProxy(new ArithmeticCalculatorImpl());
        ArithmeticCalculator calculator = proxy.getProxy();

        int result = calculator.add(5,3);
        System.out.println(result);
        result = calculator.sub(5,3);
        System.out.println(result);
        calculator.noResult();

    }
}
