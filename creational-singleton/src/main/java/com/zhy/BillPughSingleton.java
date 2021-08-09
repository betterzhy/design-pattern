package com.zhy;

/**
 * BillPush模式
 * 基于静态内部类和jvm类加载，实现懒加载的单例
 */
public class BillPughSingleton {
    private BillPughSingleton() {

    }

    /**
     * 内部类被主动引用时，发生类加载
     */
    private static class LazyHolder {
        public static final BillPughSingleton instance = new BillPughSingleton();
    }

    public BillPughSingleton getInstance() {
        /*
          对LazyHolder的，主动引用
         */
        return LazyHolder.instance;
    }
}
