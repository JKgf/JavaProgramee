package com.gf.structure.decorator;


public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    

    @Override
    public void method() {
        System.out.println("在执行被装饰类的方法之前，执行其他的代码...");
        source.method();
        System.out.println("在执行被装饰类的方法之后，执行其他的代码...");
    }

}
