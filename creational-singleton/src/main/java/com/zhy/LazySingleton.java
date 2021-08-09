package com.zhy;

/**
 * 懒汉模式
 * 基于double-checked locking，解决并发下的隐患
 */
public class LazySingleton {
    private volatile LazySingleton instance;

    private LazySingleton() {

    }

    public LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
