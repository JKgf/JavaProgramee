package com.gf.行为型模式.父类与子类关系.策略模式;


public abstract class AbstractCalculator {

    //辅助方法，解析数值
    public int[] split(String exp, String opt) {
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}