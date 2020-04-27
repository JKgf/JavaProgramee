package com.gf.structure.flyweight;
public abstract class WebSite {
    
    protected String type;//内部参数

    public WebSite(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void use(User user);
}