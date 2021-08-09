package daynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SubclassProxy implements MethodInterceptor {
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
            System.out.println("前置");
            rtValue = method.invoke(target, args);
            System.out.println("后置");
        } catch (Exception e) {

        } finally {

        }
        return rtValue;
    }
}
