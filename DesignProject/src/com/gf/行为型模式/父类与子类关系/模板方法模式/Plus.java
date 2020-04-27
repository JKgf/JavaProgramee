package com.gf.行为型模式.父类与子类关系.模板方法模式;
public class Plus extends AbstractCalculator {

    //实现calculate方法，这里是自己处理加法运算，返回结果
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}