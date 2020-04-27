package com.gf.行为型模式.类和类之间的关系.观察者模式;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();


    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    
    
    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()) {
            enumo.nextElement().update();
        }
    }
}