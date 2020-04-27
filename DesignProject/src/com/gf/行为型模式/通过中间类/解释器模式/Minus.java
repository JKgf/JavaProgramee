package com.gf.行为型模式.通过中间类.解释器模式;
public class Minus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}