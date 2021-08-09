package com.zhy;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 严格单例
 * 1、不允许反射绕过private限制
 * 2、防止反序列化创建多个对象
 */
public class StrictSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private StrictSingleton() {
        // 不允许反射绕过private限制
        if (getInstance() != null) {
            throw new RuntimeException("此对象不能被重复构建!");
        }
    }

    private static class StrictSingletonHolder {
        public static final StrictSingleton INSTANCE = new StrictSingleton();
    }

    public static StrictSingleton getInstance() {
        return StrictSingletonHolder.INSTANCE;
    }

    // 反序列化
    protected Object readResolve() {
        return getInstance();
    }
}