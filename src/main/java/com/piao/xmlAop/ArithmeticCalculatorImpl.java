package com.piao.xmlAop;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int i,int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i,int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }

    @Override
    public void noResult() {
        System.out.println("no result");
    }
}
