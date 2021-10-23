package daynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getTargetProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object rtValue = null;
        try {
            // TODO 前置增强
            rtValue = method.invoke(target, args);
            // TODO 后置增强
        } catch (Exception e) {
            // TODO
        } finally {
            // TODO
        }
        return rtValue;
    }
}

