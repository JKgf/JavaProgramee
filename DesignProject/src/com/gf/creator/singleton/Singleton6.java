package com.gf.creator.singleton;

import java.util.Vector;

public class Singleton6 {
    private static Singleton6 instance = null;
    private Vector<?> properties = null;

    public Vector<?> getProperties() {
        return properties;
    }

    private Singleton6() {
    }

   
    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton6();
        }
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public void updateProperties() {
        Singleton6 shadow = new Singleton6();
        properties = shadow.getProperties();
    }
}
