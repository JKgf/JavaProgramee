package com.gf.structure.adapter.classAdapter;


public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("这是一个目标的方法。");
    }

}
