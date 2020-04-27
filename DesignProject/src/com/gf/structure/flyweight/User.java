package com.gf.structure.flyweight;

public class User {
    
    private String userName;
    private String passWd;

    public User(String userName, String passWd) {
        this.userName = userName;
        this.passWd = passWd;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWd() {
        return passWd;
    }
}