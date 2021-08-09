package org.yuzhuangzhung;

import daynamicproxy.*;
import org.junit.jupiter.api.Test;


public class ProxyTest {

    /**
     * 调用: dynamic proxy
     * 一个Proxy对象支持所有接口代理.
     */
    @Test
    public void interfaceProxyTest() {
        ProxyGenerator cp = new ProxyGenerator();
        cp.setTarget(new Person());
        Movable targetProxy = (Movable) cp.getTargetProxy();
        targetProxy.move();
    }

    @Test
    public void subclassProxyTest() {
        SubclassProxy cp = new SubclassProxy();
        cp.setTarget(new Dog());
        Dog targetProxy = (Dog) cp.getTargetProxy();
        targetProxy.move();
    }
}
