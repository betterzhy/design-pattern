import com.zhy.StrictSingleton;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {
    @Test
    public void strictSingletonTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        StrictSingleton instance = StrictSingleton.getInstance();

        Constructor<StrictSingleton> constructor = StrictSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        StrictSingleton strictSingleton = constructor.newInstance();

        System.out.println(instance == strictSingleton);

    }
}
