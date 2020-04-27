package com.gf.creator.AbstractFactory;
public class Creater2 extends Creater {

    //创建产品A2
    @Override
    public Product createProductA() {
        return new ProductA2();
    }

  //创建产品B2
    @Override
    public Product createProductB() {
        return new ProductB2();
    }

}
