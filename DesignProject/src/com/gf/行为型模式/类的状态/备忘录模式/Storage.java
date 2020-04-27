package com.gf.行为型模式.类的状态.备忘录模式;
public class Storage {

    //拥有备忘录类的实例
    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}