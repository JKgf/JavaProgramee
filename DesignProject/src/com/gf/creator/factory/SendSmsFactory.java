package com.gf.creator.factory;


public class SendSmsFactory implements Provider {

    
    @Override
    public Sender produce() {
        return new SmsSender();
    }

}

