package com.gf.creator.prototype;
public class ConcretePrototype_深复制 extends Prototype_深复制 {

    private static final long serialVersionUID = 1L;

    public ConcretePrototype_深复制(String name,String sexName) {
        setName(name);
        setObj(new SerializableObject(sexName));
    }
}
