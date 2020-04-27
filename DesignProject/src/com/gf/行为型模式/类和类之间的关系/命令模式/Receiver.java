package com.gf.行为型模式.类和类之间的关系.命令模式;
public class Receiver {
    
    //执行命令
    public void action() {
        System.out.println("命令收到了，开始执行。");
    }
}