package com.gf.structure.flyweight;

public class ConcurrentWebSite extends WebSite {
    
    
    public ConcurrentWebSite(String type) {
        super(type);
    }
    
    
    @Override
    public void use(User user) {
        System.out.println("该网站的类型是： " + type);
        System.out.println("用户名: " + user.getUserName());
        System.out.println("密码: " + user.getPassWd());
        System.out.println();
    }
}