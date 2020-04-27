package com.gf.creator.factory.simpleFactory.mutipleFactory;
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("这是在发送邮件...");
    }

}

