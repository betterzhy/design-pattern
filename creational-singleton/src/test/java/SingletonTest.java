import com.zhy.StrictSingleton;

import java.lang.reflect.Constructor;

public class SingletonTest {
    @Test
    public void strictSingletonTest() {
        StrictSingleton instance = StrictSingleton.getInstance();

        Constructor<StrictSingleton> constructor = StrictSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        StrictSingleton strictSingleton = constructor.newInstance();

        System.out.println(instance == strictSingleton);

    }
}
