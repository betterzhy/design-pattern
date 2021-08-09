package com.zhy;

/**
 * 饥汉模式
 * 基于jvm类加载机制，不支持懒加载
 */
public class EagerSingleton {
    // 静态属性，初始化阶段，<cinit>进行赋值
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}