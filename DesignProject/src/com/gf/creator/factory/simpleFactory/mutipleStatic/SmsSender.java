package com.gf.creator.factory.simpleFactory.mutipleStatic;
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("这是在发送短信...");
    }

}

