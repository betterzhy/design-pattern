package org.yuzhuangzhung;

import daynamicproxy.*;
import daynamicproxy.service.Dog;
import daynamicproxy.service.Movable;
import daynamicproxy.service.Person;
import org.junit.jupiter.api.Test;


public class ProxyTest {

    /**
     * 调用: dynamic proxy
     * 一个Proxy对象支持所有接口代理.
     */
    @Test
    public void interfaceProxyTest() {
        JDKProxy proxy = new JDKProxy();
        proxy.setTarget(new Person());
        Movable targetProxy = (Movable) proxy.getTargetProxy();
        targetProxy.move();
    }

    @Test
    public void subclassProxyTest() {
        CGlibProxy proxy = new CGlibProxy();
        proxy.setTarget(new Dog());
        Dog targetProxy = (Dog) proxy.getTargetProxy();
        targetProxy.move();
    }
}
