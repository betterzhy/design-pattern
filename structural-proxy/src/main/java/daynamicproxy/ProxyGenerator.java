package daynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通用动态代理(基于接口)
 */
public class ProxyGenerator implements InvocationHandler {

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
            System.out.println("前置");
            rtValue = method.invoke(target, args);
            System.out.println("后置");
        } catch (Exception e) {

        } finally {

        }
        return rtValue;
    }
}

