package com.zhy.daynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {
    
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getTargetProxy() {
        return Enhancer.create(target.getClass(), this);
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object rtValue = null;
        try {
            // TODO 前置增强
            System.out.println("CGlib前置增强");
            rtValue = method.invoke(target, args);
            System.out.println("CGlib后置增强");
            // TODO 后置增强
        } catch (Exception e) {
            // TODO
        } finally {
            // TODO
        }
        return rtValue;
    }
}
