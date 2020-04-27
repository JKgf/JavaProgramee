package com.gf.creator.factory.simpleFactory.mutipleFactory;
public class SendFactory {

    
    public Sender produceMail() {
        return new MailSender();
    }

    
    public Sender produceSms() {
        return new SmsSender();
    }
}
