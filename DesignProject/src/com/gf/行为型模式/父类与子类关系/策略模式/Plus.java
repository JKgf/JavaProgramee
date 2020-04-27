package com.gf.行为型模式.父类与子类关系.策略模式;
public class Plus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        //使用辅助类中的split方法，获取数值
        int arrayInt[] = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}