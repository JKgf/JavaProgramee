package com.gf.structure.decorator;
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("执行被装饰类的方法...");
    }

}
