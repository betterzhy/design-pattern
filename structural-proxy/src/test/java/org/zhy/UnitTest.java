package org.zhy;

import com.zhy.daynamicproxy.CGlibProxy;
import com.zhy.daynamicproxy.JDKProxy;
import org.junit.jupiter.api.Test;


public class UnitTest {

    /**
     * 调用: dynamic proxy
     * 一个Proxy对象支持所有接口代理.
     */
    @Test
    public void interfaceProxyTest() {
        JDKProxy proxy = new JDKProxy();
        proxy.setTarget(new Person());
        // 必须获取接口
        Movable targetProxy = (Movable) proxy.getTargetProxy();
        targetProxy.move();
    }

    @Test
    public void subclassProxyTest() {
        CGlibProxy proxy = new CGlibProxy();
        proxy.setTarget(new Person());
        // 没有限制
        Person targetProxy = (Person) proxy.getTargetProxy();
        // Movable targetProxy = (Movable) proxy.getTargetProxy();
        targetProxy.move();
    }
}
