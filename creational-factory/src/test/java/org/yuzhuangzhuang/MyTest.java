package org.yuzhuangzhuang;

import org.junit.jupiter.api.Test;
import simplefactory.Phone;

public class MyTest {
    @Test
    public void factoryTest() {
        PhoneFactory factory = new IphoneXFactory();
        Phone phone = factory.createPhone();
    }

}
