package com.gf.creator.AbstractFactory;
public class Creater1 extends Creater {

    //创建产品A1
    @Override
    public Product createProductA() {
        return new ProductA1();
    }

    //创建产品B1
    @Override
    public Product createProductB() {
        return new ProductB1();
    }

}
