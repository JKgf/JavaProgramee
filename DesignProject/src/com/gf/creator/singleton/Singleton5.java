package com.gf.creator.singleton;
public class Singleton5 {
    private static Singleton5 instance = null;

    private Singleton5() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton5();
        }
    }

    
    public static Singleton5 getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
    
    
    /**
     * 
     * 考虑性能的话，整个程序只需创建一次实例，所以性能也不会有什么影响。
     * 
     * 
     * 补充：为单例对象的属性进行同步更新，详细代码请点击查看 Singleton6.java
     * 
     */
}
