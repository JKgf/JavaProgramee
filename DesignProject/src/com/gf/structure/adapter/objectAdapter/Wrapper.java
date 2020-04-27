package com.gf.structure.adapter.objectAdapter;
public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("这是一个目标的方法。");
    }

    @Override
    public void method1() {
        source.method1();
    }

}
