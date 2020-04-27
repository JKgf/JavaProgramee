package com.gf.行为型模式.通过中间类.中介者模式;


public interface Mediator {
    
    //管理user1、user2
    public void createMediator();

    //工作
    public void workAll();
}