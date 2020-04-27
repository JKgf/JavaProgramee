package com.gf.行为型模式.类和类之间的关系.责任链模式;

public class Test {
    public static void main(String[] args) {
        // 组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        // 提交请求
        handler1.handleRequest();
    }
    
    
    
}
